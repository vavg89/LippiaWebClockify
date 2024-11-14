package lippia.web.services;

<<<<<<< Updated upstream
=======
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

>>>>>>> Stashed changes
import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.ActionManager;
import com.crowdar.core.actions.WebActionManager;
import com.crowdar.driver.DriverManager;
import lippia.web.constants.ClockifyLoginConstants;
import org.testng.Assert;

import static com.crowdar.core.actions.WebActionManager.navigateTo;
import static com.crowdar.core.actions.WebActionManager.waitTabOpening;

public class ClockifyLoginService extends ActionManager {

    public static void navegarWeb(){
        navigateTo(PropertyManager.getProperty("web.base.url"));
    }

    public static void enterLoginPage(){
        click(ClockifyLoginConstants.HEADER_lOGIN_XPATH);
    }

<<<<<<< Updated upstream
    public static void login(String email, String password) {
        //click(ClockifyLoginConstants.BUTTON_MANUAL_LOGIN_XPATH);
        setInput(ClockifyLoginConstants.INPUT_EMAIL_NAME, email);
        setInput(ClockifyLoginConstants.INPUT_PASSWORD_NAME, password);
        click(ClockifyLoginConstants.BUTTON_LOGIN_XPATH);
=======
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
>>>>>>> Stashed changes
    }

    public static void login(String escenario) {

<<<<<<< Updated upstream
    public static void clickButtonWithText(String text) {
        click(ClockifyLoginConstants.BUTTON_LOGIN_WITHTEXT_XPATH.replace("%s",text));
    }

    public static void verifyUrl(String url){
        Assert.assertEquals(url,DriverManager.getDriverInstance().getCurrentUrl(), "Url No coincide");
=======
        String emailCorrecto = PropertyManager.getProperty("web.email");
        String passwordCorrecto = PropertyManager.getProperty("web.password");
        switch (escenario.toLowerCase()) {

            case "con datos validos":
                setInput(ClockifyLoginConstants.INPUT_EMAIL_NAME, emailCorrecto);
                setInput(ClockifyLoginConstants.INPUT_PASSWORD_NAME, passwordCorrecto);
                click(ClockifyLoginConstants.BUTTON_LOGIN_XPATH);
                break;

            default:
                throw new IllegalArgumentException("Tipo de escenario no reconocido: " + escenario);
        }
    }

    public static void verificarResultado(String resultado) {
        WebDriver driver = DriverManager.getDriverInstance();
        WebDriverWait wait = new WebDriverWait(driver, 30);

        switch (resultado.toLowerCase()) {
            case "accedido":
                // Esperar a que la URL sea la esperada antes de hacer la validación
                try {
                    wait.until(ExpectedConditions.urlToBe("https://app.clockify.me/tracker#"));
                } catch (Exception e) {
                    throw new AssertionError("La URL no se cargó correctamente después de esperar", e);
                }

                // Realizar la aserción una vez que la condición sea verdadera
                Assert.assertEquals(driver.getCurrentUrl(), "https://app.clockify.me/tracker#", "La URL no coincide con la esperada.");
                break;

            default:
                throw new IllegalArgumentException("Tipo de escenario no reconocido: " + resultado);
        }
>>>>>>> Stashed changes
    }

}
