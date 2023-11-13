package marrero_ferrera_gcid_ulpgc.test.control;

import marrero_ferrera_gcid_ulpgc.test.model.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.Instant;

public class Main {
    public static void main(String[] args) throws SQLException {
        Location location = new Location(28.01f, -15.58f, "Gran Canaria", "Risco Prieto");
        String apiKey = "3c3aea5ce433b076c2f83b0c608896d8";
        String dbPath = "weatherDataBase.db";
        WeatherController controller = new WeatherController(location, apiKey, dbPath);

        /*
        String dbPath = "weatherDataBase.db";
        WeatherController controller = new WeatherController(location, apiKey, dbPath);
        Connection connection = controller.getWeatherStore().connectWeather();
        controller.getWeatherStore().createTable(connection);

         */

        Instant instant = Instant.parse("2023-11-14T12:00:00Z");
        OpenWeatherMapSupplier supplier = new OpenWeatherMapSupplier(location, apiKey);
        Weather weather = supplier.getWeather(location, instant);
        System.out.println(weather.toString());


        /*
        0. Cargar localizaciones
        1. Crear controladores
        2. crear tarea periódica
            2.1 ejecutar tarea (WeatherController -> execute() )
            CREAR CLASES "WEATHERCONTROLLER Y WEATHERSUPPLIER"
        3.
         */

        // DESERIALIZAR CON GSON EL TEXTO DEL API TESTER
        // JsonObject.class
    }
}