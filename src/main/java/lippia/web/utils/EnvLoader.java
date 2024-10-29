package lippia.web.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class EnvLoader {
    public static void loadEnv() {
        try (Stream<String> lines = Files.lines(Paths.get(".env"))) {
            lines.filter(line -> line.contains("=")).forEach(line -> {
                String[] keyValue = line.split("=", 2);
                // validar si se estan cargando las vartiables de entorno
                //System.out.println("Cargando variable: " + keyValue[0] + " = " + keyValue[1]);
                System.setProperty(keyValue[0], keyValue[1]);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
