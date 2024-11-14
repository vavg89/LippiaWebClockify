package lippia.web.steps;

import com.crowdar.core.PageSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lippia.web.services.ClockifyRegistroHorasService;

public class ClockifyRegistroHorasSteps extends PageSteps {

    @And("^El usuario ingresa los datos (.*) desde el (.*) hasta el (.*) del (.*)")
    public void completarFormulario(String scenarioType, String fechaProporcionada, String horaDesdeProporcionada, String horaHastaProporcionada) {
        ClockifyRegistroHorasService.RegistroHoras(scenarioType, fechaProporcionada, horaDesdeProporcionada, horaHastaProporcionada);
    }

    @Then("^Se visualiza el (.*)$")
    public void verificarResultado(String varLogica) {
        ClockifyRegistroHorasService.verificarResultadoRegistroHoras(varLogica);
    }
}
