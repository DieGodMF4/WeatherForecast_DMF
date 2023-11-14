package marrero_ferrera_gcid_ulpgc.test.model;

import com.google.gson.JsonObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.time.Instant;

public class OpenWeatherMapSupplier implements WeatherSupplier {
    private Location location;
    private String apiKey;

    public OpenWeatherMapSupplier(Location location, String apiKey) {
        this.location = location;
        this.apiKey = apiKey;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public Weather getWeather(Location location, Instant ts) {
        HttpClient httpClient = HttpClients.createDefault();

        String httpUrl = "https://api.openweathermap.org/data/2.5/forecast?lat=" + location.getLatitude() +
                "&lon=" + location.getLongitude() + "&units=metric&appid=" + apiKey;
        HttpGet httpGet = new HttpGet(httpUrl);

        try {
            HttpResponse response = httpClient.execute(httpGet);
            String json = EntityUtils.toString(response.getEntity());

            long unixTimestamp = ts.getEpochSecond();

            JsonObject jsonObject = new com.google.gson.JsonParser().parse(json).getAsJsonObject();

            float temperature;
            float humidity;
            String weatherType;
            int cloud;
            float rain;

            int listSize = jsonObject.getAsJsonArray("list").size();

            for (int i = 0; i < listSize; i++) {
                JsonObject currentListObject = jsonObject.getAsJsonArray("list").get(i).getAsJsonObject();
                if (currentListObject.get("dt").getAsLong() == unixTimestamp) {
                    temperature = currentListObject.getAsJsonObject("main")
                            .get("temp").getAsFloat();
                    weatherType = currentListObject.getAsJsonArray("weather")
                            .get(0).getAsJsonObject().get("main").getAsString();
                    cloud = currentListObject.getAsJsonObject("clouds")
                            .get("all").getAsInt();
                    humidity = currentListObject.getAsJsonObject("main")
                            .get("humidity").getAsFloat();
                    rain = currentListObject.get("pop").getAsFloat();
                    Weather weather = new Weather(weatherType, cloud, temperature, humidity, location, ts, rain);
                    return weather;
                }
            }

            throw new Exception("Location or time were incorrect!");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
