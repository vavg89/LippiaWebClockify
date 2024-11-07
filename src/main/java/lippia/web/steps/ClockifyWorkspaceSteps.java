package lippia.web.steps;

import com.crowdar.core.PageSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lippia.web.services.ClockifyWorkspaceService;

public class ClockifyWorkspaceSteps extends PageSteps {


    @And("^El usuario ingresa el nombre del espacio de trabajo (.*) y hace click en el boton CREAR")
    public void completarFormulario(String scenarioType) {
        ClockifyWorkspaceService.NombreWorkspace(scenarioType);
    }

    @Then("^Se muestra el (.*)$")
    public void verificarResultado(String varLogica) {
        ClockifyWorkspaceService.verificarResultadoWorkspace(varLogica);
    }
}
