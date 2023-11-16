package marrero_ferrera_gcid_ulpgc.test.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;

public class WeatherController {
    private ArrayList<Weather> weathers;

    public WeatherController() {
        weathers = new ArrayList<>();
    }

    public void getAndStoreWeatherData(Location location, String apiKey, String dbPath, Instant instant) throws SQLException {
        OpenWeatherMapSupplier supplier = new OpenWeatherMapSupplier(apiKey);
        Weather weather = supplier.getWeather(location, instant);

        SQLiteWeatherStore store = new SQLiteWeatherStore(dbPath);
        Connection connection = store.connectWeather();
        store.createTable(connection);
        store.insertWeather(weather);
        addWeather(weather);
    }

    public void addWeather(Weather weather) {
        if (!weathers.contains(weather)) {
            weathers.add(weather);
        } else {
            System.out.println("That weather is already in the list!");
        }
    }
}

