package lippia.web.steps;

import com.crowdar.core.PageSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lippia.web.services.ClockifyProjectService;

public class ClockifyProjectSteps extends PageSteps {

    @Given("^Estoy en el dashboard de clockify$")
    public void estoyEnDashboard() {
        ClockifyProjectService.ingresarAClockify();
    }

    @And("^El usuario completa el formulario (.*)$")
    public void completarFormulario(String scenarioType) {
        ClockifyProjectService.completarFormulario(scenarioType);
    }

    @Then("^El usuario visualiza el (.*)$")
    public void verificarResultado(String varLogica) {
        ClockifyProjectService.verificarResultado(varLogica);
    }
}
