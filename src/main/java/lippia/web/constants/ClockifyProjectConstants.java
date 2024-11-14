package lippia.web.constants;

public class ClockifyProjectConstants {

    // botones en la interfaz
    public static final String BUTTON_PROYECTOS_XPATH = "xpath://a[@href='/projects' and contains(@class, 'cl-nav-link') and contains(., 'Proyectos')]";
    public static final String BUTTON_CREAR_PROYECTO_XPATH = "xpath://button[@data-cy='create-new-project' and contains(text(),'Crear nuevo')]";
    public static final String BUTTON_LOGIN_2_MENU_XPATH = "xpath://a[contains(@class,'btn-login') and text()='Log in']";
    public static final String BUTTON_PLACEHOLDER_XPATH = "xpath://input[@placeholder='Buscar por nombre']";
    public static final String BUTTON_APLICAR_XPATH = "xpath://button[normalize-space()='Aplicar filtro']";
    public static final String BUTTON_ARROW_DOWN_XPATH = "xpath://a[@class='cl-ml-auto cl-auto-pointer-event']//img[@alt='Down arrow symbol']";
    

    // formulario
    public static final String INPUT_NOMBRE_PROYECTO_XPATH = "xpath://input[@type='text' and @placeholder='Introduce el nombre de proyecto']";
    public static final String SELECTOR_CLIENTE_XPATH = "xpath://button[@data-cy='client-dropdown']";
    public static final String INPUT_SELECTOR_CLIENTE_XPATH = "xpath://input[@type='text' and @placeholder='Agregar/Buscar cliente']";
    public static final String BUTTON_GUARDAR_PROYECTO_XPATH = "xpath://button[@data-cy='create-project']";
    public static final String BUTTON_CREAR_CLIENTE_XPATH = "xpath://a[contains(@class, 'cl-color-blue') and contains(text(), 'crear')]";

    // XPath para verificar si un proyecto duplicado existe
    public static final String PROYECTO_DUPLICADO_XPATH = "xpath://a[contains(@class, 'cl-project-name') and contains(text(), '%s')]";
    public static final String CLIENTE_EN_LISTA_XPATH = "xpath://li[@class='cl-dropdown-item pointer ng-star-inserted' and @title='%s']";
    public static final String PROJECT_CLIENTE_IN_TABLE_XPATH = "xpath://span[normalize-space()='%s']";

}
