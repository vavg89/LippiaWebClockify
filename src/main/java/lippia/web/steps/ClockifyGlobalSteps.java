package lippia.web.steps;

import com.crowdar.core.PageSteps;

import io.cucumber.java.en.When;
import lippia.web.services.ClockifyGlobalService;

public class ClockifyGlobalSteps extends PageSteps {

    @When("^El usuario hace click en el boton (.*)$")
    public void clickButtonWithText(String text) {
        ClockifyGlobalService.clickBoton(text);
    }
}
