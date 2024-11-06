package lippia.web.services;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.ActionManager;
import static com.crowdar.core.actions.WebActionManager.navigateTo;

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
        WebDriver driver = getDriver(); // Obtén el WebDriver desde la clase base ActionManager
        
        switch (varLogica.toLowerCase()) {
            case "proyecto creado correctamente":
                setInput(ClockifyProjectConstants.BUTTON_PLACEHOLDER_XPATH, projectName);
                WebElement searchBox = driver.findElement(By.xpath(ClockifyProjectConstants.BUTTON_PLACEHOLDER_XPATH));
                searchBox.sendKeys(Keys.ENTER);
                click(ClockifyProjectConstants.BUTTON_ARROW_DOWN_XPATH);

                String projectXpath = String.format(ClockifyProjectConstants.PROJECT_NAMES_IN_TABLE_XPATH, projectName);
                boolean isProjectPresent = isElementPresent(projectXpath, driver);

                if (!isProjectPresent) {
                    throw new AssertionError("El proyecto con nombre " + projectName + " no fue encontrado en la tabla.");
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
