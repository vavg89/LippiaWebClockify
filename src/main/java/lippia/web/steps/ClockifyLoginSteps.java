package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.services.ClockifyLoginService;

public class ClockifyLoginSteps extends PageSteps {

    @Given("^The client is on clockify page$")
    public void home() {
        ClockifyLoginService.navegarWeb();
    }


    @When("^The client login with credentials email (.*) and password (.*)$")
    public void login(String email, String password) {
        //ClockifyLoginService.enterLoginPage();
        ClockifyLoginService.login(email,password);
    }

    @When("^The client click (.*) button$")
    public void clickButtonText(String text) {
        ClockifyLoginService.clickButtonWithText(text);
    }
    @Then("The client verify clockify home page is displayed")
    public void clockifyHomePageIsDisplayed() {
        ClockifyLoginService.verifyMessage();
        ClockifyLoginService.verifyUrl("https://app.clockify.me/tracker#");
    }
}
