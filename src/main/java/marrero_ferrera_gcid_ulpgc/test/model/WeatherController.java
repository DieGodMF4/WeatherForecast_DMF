package marrero_ferrera_gcid_ulpgc.test.model;

import java.util.ArrayList;

public class WeatherController {
    private WeatherSupplier weatherSupplier;
    private ArrayList<Weather> weathers;
    private WeatherStore weatherStore;

    public WeatherController(Location location, String apiKey, String dbPath) {
        this.weatherSupplier = new OpenWeatherMapSupplier(location, apiKey);
        this.weatherStore = new SQLiteWeatherStore(dbPath);
    }

    /*
    public void fetchAndStoreWeatherData() {
        // Fetch weather data from the API using WeatherSupplier
        WeatherData weatherData = weatherSupplier.fetchWeatherData();

        // Store the weather data in the database using WeatherStore
        weatherStore.storeWeatherData(weatherData);
    }

     */

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

    public WeatherSupplier getWeatherSupplier() {
        return weatherSupplier;
    }

    public void setWeatherSupplier(WeatherSupplier weatherSupplier) {
        this.weatherSupplier = weatherSupplier;
    }

    public WeatherStore getWeatherStore() {
        return weatherStore;
    }

    public void setWeatherStore(WeatherStore weatherStore) {
        this.weatherStore = weatherStore;
    }

}

