package lippia.web.services;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.ActionManager;
import com.crowdar.core.actions.WebActionManager;
import com.crowdar.driver.DriverManager;
import lippia.web.constants.ClockifyLoginConstants;
import org.testng.Assert;

import static com.crowdar.core.actions.WebActionManager.navigateTo;
import static com.crowdar.core.actions.WebActionManager.waitTabOpening;

public class ClockifyLoginService extends ActionManager {

    public static void navegarWeb(){
        navigateTo(PropertyManager.getProperty("web.base.url"));
    }

    public static void enterLoginPage(){
        click(ClockifyLoginConstants.HEADER_lOGIN_XPATH);
    }

    public static void login(String email, String password) {
        //click(ClockifyLoginConstants.BUTTON_MANUAL_LOGIN_XPATH);
        setInput(ClockifyLoginConstants.INPUT_EMAIL_NAME, email);
        setInput(ClockifyLoginConstants.INPUT_PASSWORD_NAME, password);
        click(ClockifyLoginConstants.BUTTON_LOGIN_XPATH);
    }

    public static void verifyMessage() {
        waitVisibility(ClockifyLoginConstants.MESSAGE_XPATH);
        Assert.assertTrue(isVisible(ClockifyLoginConstants.MESSAGE_XPATH));
    }

    public static void clickButtonWithText(String text) {
        click(ClockifyLoginConstants.BUTTON_LOGIN_WITHTEXT_XPATH.replace("%s",text));
    }

    public static void verifyUrl(String url){
        Assert.assertEquals(url,DriverManager.getDriverInstance().getCurrentUrl(), "Url No coincide");
    }
}
