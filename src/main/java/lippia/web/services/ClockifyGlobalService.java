package lippia.web.services;

import com.crowdar.core.actions.ActionManager;

import lippia.web.constants.ClockifyLoginConstants;
import lippia.web.constants.ClockifyProjectConstants;
import lippia.web.constants.ClockifyWorkspaceConstants;

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
            case "workspace":
                click(ClockifyWorkspaceConstants.BUTTON_WORKSPACE_XPATH);
                break;
            case "gestionar espacios de trabajo":
                click(ClockifyWorkspaceConstants.BUTTON_G_WORKSPACE_XPATH);
                break;
            case "crear nuevo espacio de trabajo":
                click(ClockifyWorkspaceConstants.BUTTON_CREATE_WORKSPACE_E_XPATH);
                break;
            case "CREAR WORKSPACE":
                click(ClockifyWorkspaceConstants.BUTTON_CREATE_WORKSPACE_XPATH);
                break;
            default:
                throw new IllegalArgumentException("Botón no encontrado: " + boton);
        }
    }
}
