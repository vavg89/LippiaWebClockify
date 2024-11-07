package lippia.web.services;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.ActionManager;
import static com.crowdar.core.actions.WebActionManager.navigateTo;
import com.crowdar.driver.DriverManager;

import lippia.web.constants.ClockifyProjectConstants;

public class ClockifyProjectService extends ActionManager {

    private static String projectName;
    private static String projectCliente;

    public static void ingresarAClockify() {
        navigateTo(PropertyManager.getProperty("web.base.url"));
        click(ClockifyProjectConstants.BUTTON_LOGIN_2_MENU_XPATH);
    }

    public static void completarFormulario(String scenarioType) {
        switch (scenarioType) {
            case "correctamente":
                projectName = generarNombreAleatorio("Proyecto");
                projectCliente = generarNombreAleatorio("Cliente");

                setInput(ClockifyProjectConstants.INPUT_NOMBRE_PROYECTO_XPATH, projectName);
                click(ClockifyProjectConstants.SELECTOR_CLIENTE_XPATH);
                setInput(ClockifyProjectConstants.INPUT_SELECTOR_CLIENTE_XPATH, projectCliente);
                click(ClockifyProjectConstants.BUTTON_CREAR_CLIENTE_XPATH);
                click(ClockifyProjectConstants.BUTTON_GUARDAR_PROYECTO_XPATH);

                break;

            default:
                throw new IllegalArgumentException("Tipo de escenario no reconocido: " + scenarioType);
        }
    }

    private static String generarNombreAleatorio(String baseNombre) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            sb.append(caracteres.charAt(random.nextInt(caracteres.length())));
        }
        return baseNombre + "_" + sb.toString();
    }

   public static void verificarResultado(String varLogica) {
    WebDriver driver = DriverManager.getDriverInstance(); // Obtiene el WebDriver a partir del DriverManager

    switch (varLogica.toLowerCase()) {
        case "proyecto creado correctamente":
            // Establece el filtro para buscar el proyecto en la tabla
            setInput(ClockifyProjectConstants.BUTTON_PLACEHOLDER_XPATH, projectName);
            click(ClockifyProjectConstants.BUTTON_APLICAR_XPATH);

            // Verifica si el nombre del proyecto y el cliente están presentes
            boolean isProjectPresent = isElementPresent("//span[normalize-space()='" + projectName + "']", driver);
            boolean isClientPresent = isElementPresent("//span[normalize-space()='" + projectCliente + "']", driver);

            // Validación: si alguno no está presente, lanza un error
            if (!isProjectPresent || !isClientPresent) {
                throw new AssertionError("El proyecto con nombre '" + projectName + "' o el cliente '" + projectCliente + "' no fueron encontrados en la tabla.");
            }
            break;

        default:
            throw new IllegalArgumentException("Tipo de escenario no reconocido: " + varLogica);
    }

}

private static boolean isElementPresent(String xpath, WebDriver driver) {
    try {
        WebElement element = driver.findElement(By.xpath(xpath));
        return element.isDisplayed();
    } catch (NoSuchElementException e) {
        return false;
    }
}
}
