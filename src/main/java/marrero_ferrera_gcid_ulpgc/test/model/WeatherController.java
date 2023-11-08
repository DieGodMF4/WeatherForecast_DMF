package marrero_ferrera_gcid_ulpgc.test.model;

public class WeatherController {
    private WeatherSupplier weatherSupplier;
    private WeatherStore weatherStore;

    public WeatherController(Location location, String apiKey) {
        // Initialize the WeatherSupplier and WeatherStore objects
        this.weatherSupplier = new OpenWeatherMapSupplier(location, apiKey);
        this.weatherStore = new SQLiteWeatherStore();
    }

    /*
    public void fetchAndStoreWeatherData() {
        // Fetch weather data from the API using WeatherSupplier
        WeatherData weatherData = weatherSupplier.fetchWeatherData();

        // Store the weather data in the database using WeatherStore
        weatherStore.storeWeatherData(weatherData);
    }

     */

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

