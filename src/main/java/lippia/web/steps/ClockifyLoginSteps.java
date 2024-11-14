package lippia.web.steps;

import com.crowdar.core.PageSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lippia.web.services.ClockifyLoginService;

public class ClockifyLoginSteps extends PageSteps {

    @Given("Ingreso a clockify web")
    public void home() {
        ClockifyLoginService.navegarWeb();
    }

    @And("^El usuario selecciona el idioma (.*)$")
    public void seleccionarIdioma(String idioma) {
        ClockifyLoginService.seleccionarIdioma(idioma);
    }

    @And("^El usuario ingresa a clockify (.*)$")
    public void login(String escenario) {
        ClockifyLoginService.login(escenario);
    }

    @Then("^El usuario debe haber (.*)$")
    public void clockifyHomePageIsDisplayed(String resultado) {
        ClockifyLoginService.verificarResultado(resultado);
    }
}
