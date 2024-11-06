package lippia.web.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.core.PropertyManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.services.ClockifyLoginService;

public class ClockifyLoginSteps extends PageSteps {

    @Given("Ingreso a clockify web")
    public void home() {
        ClockifyLoginService.navegarWeb();
    }

    @When("^El usuario selecciona el idioma (.*)$")
    public void seleccionarIdioma(String idioma) {
        ClockifyLoginService.seleccionarIdioma(idioma);
    }

    @When("^El usuario ingresa las credenciales (.*) y la contraseña (.*) he ingresa$")
    public void login(String emailPlaceholder, String passwordPlaceholder) {

        String email = PropertyManager.getProperty("web.email");
        String password = PropertyManager.getProperty("web.password");

        //System.out.println("Email: " + email);
        //System.out.println("Password: " + password);
        ClockifyLoginService.login(email, password);
    }

    @Then("^El usuario debe haber (.*)$")
    public void clockifyHomePageIsDisplayed(String resultado) {
        ClockifyLoginService.verificarResultado(resultado);
    }
}
