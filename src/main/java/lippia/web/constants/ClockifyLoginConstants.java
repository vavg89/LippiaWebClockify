package lippia.web.constants;

public class ClockifyLoginConstants {

    public static final String HEADER_lOGIN_XPATH = "xpath://div[@class='header__row__item_right']//a[.='Inicia Sesión']";
    public static final String BUTTON_MANUAL_LOGIN_XPATH = "xpath://a[@data-test-id='login-manual']";
    public static final String INPUT_EMAIL_NAME = "name:email";
    public static final String INPUT_PASSWORD_NAME = "xpath://input[@class='cl-form-control']";
    public static final String BUTTON_LOGIN_XPATH = "xpath://button[@data-test-id='login-button']";
    public static final String MESSAGE_XPATH = "xpath://span[@class='cl-h1 cl-text-gray-3']";
    public static final String BUTTON_LOGIN_WITHTEXT_XPATH = "xpath://a[contains(.,'Log in')]";
     public static final String BUTTON_LOGIN_MANUAL_XPATH = "xpath://a[contains(.,'Log in manually')]";
    public static final String BUTTON_IDIOMA_XPATH = "xpath://div[@data-cy='language-dropdown']";
    public static final String ITEM_IDIOMA_XPATH = "xpath://div[contains(text(),'%s')]";
    public static final String BUTTON_LOGOUT_XPATH = "xpath://a[@data-cy='logout']";
    
}
