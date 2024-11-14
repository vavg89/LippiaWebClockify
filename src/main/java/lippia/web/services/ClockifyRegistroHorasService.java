package lippia.web.services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crowdar.core.actions.ActionManager;
import com.crowdar.driver.DriverManager;

import lippia.web.constants.ClockifyRegistroHorasConstants;

public class ClockifyRegistroHorasService extends ActionManager {

    private static String HoraDesde;
    private static String HoraHasta;
    private static String Fecha;

    public static void RegistroHoras(String scenarioType, String horaDesdeProporcionada, String horaHastaProporcionada, String fechaProporcionada) {
        switch (scenarioType) {
            case "correctamente":
                Fecha = fechaProporcionada;
                HoraDesde = horaDesdeProporcionada;
                HoraHasta = horaHastaProporcionada;

                click(ClockifyRegistroHorasConstants.BUTTON_RASTREADOR_XPATH);
                click(ClockifyRegistroHorasConstants.BUTTON_MANUAL_XPATH);
                click(ClockifyRegistroHorasConstants.INPUT_REGISTROHORAS_DESDE_XPATH);
                setInput(ClockifyRegistroHorasConstants.INPUT_REGISTROHORAS_DESDE_XPATH, HoraDesde);
                click(ClockifyRegistroHorasConstants.INPUT_REGISTROHORAS_HASTA_XPATH);
                setInput(ClockifyRegistroHorasConstants.INPUT_REGISTROHORAS_HASTA_XPATH, HoraHasta);
                click(ClockifyRegistroHorasConstants.INPUT_REGISTROHORAS_FECHA_XPATH);
                setInput(ClockifyRegistroHorasConstants.INPUT_REGISTROHORAS_FECHA_XPATH, Fecha);
                click(ClockifyRegistroHorasConstants.BUTTON_FECHA_XPATH);
                break;

            default:
                throw new IllegalArgumentException("Tipo de escenario no reconocido: " + scenarioType);
        }
    }

    public static void verificarResultadoRegistroHoras(String varLogica) {
        WebDriver driver = DriverManager.getDriverInstance();

        switch (varLogica.toLowerCase()) {
            case "registro creado exitosamente":
                try {
                    WebDriverWait wait = new WebDriverWait(driver, 30);
                    WebElement mensajeExito = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Se ha creado la entrada de tiempo']")));
                    if (!mensajeExito.isDisplayed()) {
                        throw new AssertionError("No se encontró el mensaje de confirmación de creación del registro de horas.");
                    }
                } catch (Exception e) {
                    throw new AssertionError("No se encontró el mensaje de confirmación de creación del registro de horas. Error: " + e.getMessage());
                }
                break;

            default:
                throw new IllegalArgumentException("Tipo de escenario no reconocido: " + varLogica);
        }
    }
}