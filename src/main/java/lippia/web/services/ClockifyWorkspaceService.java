package lippia.web.services;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crowdar.core.actions.ActionManager;
import com.crowdar.driver.DriverManager;

import lippia.web.constants.ClockifyWorkspaceConstants;

public class ClockifyWorkspaceService extends ActionManager {

    private static String workspaceValido;

    public static void NombreWorkspace(String scenarioType) {
        switch (scenarioType) {
            case "correctamente":
                workspaceValido = generarNombreAleatorio("Prueba");
               

                setInput(ClockifyWorkspaceConstants.INPUT_WORKSPACE_XPATH, workspaceValido);
                click(ClockifyWorkspaceConstants.BUTTON_CREATE_WORKSPACE_XPATH);
                break;

            default:
                throw new IllegalArgumentException("Tipo de escenario no reconocido: " + scenarioType);
        }
    }



private static String generarNombreAleatorio(String baseNombre) {
    // Generar un timestamp con fecha y hora actual hasta milisegundos
    String timestamp = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
    return baseNombre + "_" + timestamp;
}


public static void verificarResultadoWorkspace(String varLogica) {
        WebDriver driver = DriverManager.getDriverInstance();

        switch (varLogica.toLowerCase()) {
            case "workspace creado como activo":
                scrollToLastElement(driver);
                boolean isWorkspacePresent = waitForElementToBeVisible("//span[normalize-space()='" + workspaceValido + "']", driver);

                if (!isWorkspacePresent) {
                    throw new AssertionError("El espacio de trabajo con nombre '" + workspaceValido + "' no fue encontrado en la tabla.");
                }
                break;

            default:
                throw new IllegalArgumentException("Tipo de escenario no reconocido: " + varLogica);
        }
    }

private static boolean waitForElementToBeVisible(String xpath, WebDriver driver) {
    try {
        WebDriverWait wait = new WebDriverWait(driver, 30); 
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return element.isDisplayed();
    } catch (Exception e) {
        return false;
    }
}


 private static void scrollToLastElement(WebDriver driver) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement container = driver.findElement(By.xpath("//div[@class='cl-page-wrapper']"));
            js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", container);
        } catch (Exception e) {
             throw e;
        }
    }
}
