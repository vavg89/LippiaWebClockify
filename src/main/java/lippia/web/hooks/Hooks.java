package lippia.web.hooks;

import io.cucumber.java.Before;
import lippia.web.utils.EnvLoader;

public class Hooks {

    @Before
    public void loadEnvironmentVariables() {
        EnvLoader.loadEnv();
    }
}
