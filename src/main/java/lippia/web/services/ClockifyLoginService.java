package lippia.web.services;

import org.testng.Assert;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.ActionManager;
import static com.crowdar.core.actions.WebActionManager.navigateTo;
import com.crowdar.driver.DriverManager;

import lippia.web.constants.ClockifyLoginConstants;

public class ClockifyLoginService extends ActionManager {

    public static void navegarWeb() {
        navigateTo(PropertyManager.getProperty("web.base.url"));
    }

    public static void enterLoginPage() {
        click(ClockifyLoginConstants.HEADER_lOGIN_XPATH);
    }

public static void seleccionarIdioma(String idioma) {
    // Verificar si el idioma actual ya es el seleccionado
    String idiomaActual = getText(ClockifyLoginConstants.BUTTON_IDIOMA_XPATH); // Obtener el idioma actual mostrado
    if (!idiomaActual.equalsIgnoreCase(idioma)) {
        // Si el idioma no es el esperado, abrir el menú desplegable y seleccionar el idioma correcto
        click(ClockifyLoginConstants.BUTTON_IDIOMA_XPATH);
        String xpathIdioma = String.format(ClockifyLoginConstants.ITEM_IDIOMA_XPATH, idioma);
        click(xpathIdioma);
    } else {
        System.out.println("El idioma " + idioma + " ya está seleccionado.");
    }
}


    public static void login(String email, String password) {
        //click(ClockifyLoginConstants.BUTTON_MANUAL_LOGIN_XPATH);
        setInput(ClockifyLoginConstants.INPUT_EMAIL_NAME, email);
        setInput(ClockifyLoginConstants.INPUT_PASSWORD_NAME, password);
        click(ClockifyLoginConstants.BUTTON_LOGIN_XPATH);
    }

    public static void verifyMessage() {
        waitVisibility(ClockifyLoginConstants.MESSAGE_XPATH);
        Assert.assertTrue(isVisible(ClockifyLoginConstants.MESSAGE_XPATH));
    }

    public static void verifyUrl(String url) {
        Assert.assertEquals(url, DriverManager.getDriverInstance().getCurrentUrl(), "Url No coincide");
    }

    private static boolean isTextPresentOnPage(String text) {
        String pageSource = DriverManager.getDriverInstance().getPageSource();
        return pageSource.contains(text);
    }

    public static void verificarResultado(String resultado) {
        if (resultado.equalsIgnoreCase("accedido")) {
            verifyMessage();
            verifyUrl("https://app.clockify.me/tracker#");
        } else {
            boolean isTextPresent = isTextPresentOnPage(resultado);
            if (isTextPresent) {
                System.out.println("El texto '" + resultado + "' fue encontrado en la página.");
            } else {
                throw new AssertionError("El texto '" + resultado + "' no fue encontrado en la página.");
            }
        }
    }
}
