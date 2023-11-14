package marrero_ferrera_gcid_ulpgc.test.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;

public class WeatherController {
    private WeatherSupplier weatherSupplier = null;
    private ArrayList<Weather> weathers;
    private WeatherStore weatherStore = null;

    public WeatherController() {
        weathers = new ArrayList<>();
    }

    public void getAndStoreWeatherData(Location location, String apiKey, String dbPath, Instant instant) throws SQLException {
        OpenWeatherMapSupplier supplier = new OpenWeatherMapSupplier(location, apiKey);
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

    public ArrayList<Weather> getWeathers() {
        return weathers;
    }

    public WeatherSupplier getWeatherSupplier(Location location, String apiKey) {
        if (weatherSupplier != null) {
            return weatherSupplier;
        } else {
            this.weatherSupplier = new OpenWeatherMapSupplier(location, apiKey);
            return weatherSupplier;
        }
    }

    public void setWeatherSupplier(WeatherSupplier weatherSupplier) {
        this.weatherSupplier = weatherSupplier;
    }

    public WeatherStore getWeatherStore(String dbPath) {
        if (weatherStore != null) {
            return weatherStore;
        } else {
            this.weatherStore = new SQLiteWeatherStore(dbPath);
            return weatherStore;
        }
    }

    public void setWeatherStore(WeatherStore weatherStore) {
        this.weatherStore = weatherStore;
    }

}

