package lippia.web.services;

import com.crowdar.core.actions.ActionManager;

import lippia.web.constants.ClockifyLoginConstants;
import lippia.web.constants.ClockifyProjectConstants;

public class ClockifyGlobalService extends ActionManager {

    public static void clickBoton(String boton) {
        switch (boton) {
            case "PROYECTOS":
                click(ClockifyProjectConstants.BUTTON_PROYECTOS_XPATH);
                break;
            case "CREAR NUEVO PROYECTO":
                click(ClockifyProjectConstants.BUTTON_CREAR_PROYECTO_XPATH);
                break;
            case "CREAR":
                click(ClockifyProjectConstants.BUTTON_GUARDAR_PROYECTO_XPATH);
                break;
            case "Login":
                click(ClockifyLoginConstants.BUTTON_LOGIN_WITHTEXT_XPATH);
                break;
            case "Login manual":
                click(ClockifyLoginConstants.BUTTON_LOGIN_MANUAL_XPATH);
                break;
            default:
                throw new IllegalArgumentException("Botón no encontrado: " + boton);
        }
    }
}
