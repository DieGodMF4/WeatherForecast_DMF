package marrero_ferrera_gcid_ulpgc.test.model;

import com.google.gson.JsonObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class OpenWeatherMapSupplier implements WeatherSupplier {
    private Location location;
    private String apiKey; // 3c3aea5ce433b076c2f83b0c608896d8

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

    /*
        @Override
        public Weather getWeather(){
            HttpClient httpClient = HttpClients.createDefault();

            String httpUrl = "https://api.openweathermap.org/data/2.5/forecast?lat=" + location.getLatitude() +
                    "&lon=" + location.getLongitude() + "&units=metric&appid=" + apiKey;
            HttpGet httpGet = new HttpGet(httpUrl);

            try {
                HttpResponse response = httpClient.execute(httpGet);
                String json = EntityUtils.toString(response.getEntity());

                JsonObject jsonObject = new com.google.gson.JsonParser().parse(json).getAsJsonObject();

                // Extract the "temp" value
                int listSize = jsonObject.getAsJsonArray("list").size();
                List<Float> tempValues = new ArrayList<>();

                for (int i=0;i<listSize;i++){
                    tempValues.add(jsonObject.getAsJsonArray("list")
                            .get(i)
                            .getAsJsonObject()
                            .getAsJsonObject("main")
                            .get("temp")
                            .getAsFloat());
                }

                System.out.println("Temperature: " + tempValues);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    */
    @Override
    public Weather getWeather(Location location, Instant ts) { //ts= instante en el que se hace la consulta
        HttpClient httpClient = HttpClients.createDefault();

        String httpUrl = "https://api.openweathermap.org/data/2.5/forecast?lat=" + location.getLatitude() +
                "&lon=" + location.getLongitude() + "&units=metric&appid=" + apiKey;
        HttpGet httpGet = new HttpGet(httpUrl);

        try {
            HttpResponse response = httpClient.execute(httpGet);
            String json = EntityUtils.toString(response.getEntity());

            JsonObject jsonObject = new com.google.gson.JsonParser().parse(json).getAsJsonObject();

            // Extract the "temp" value
            int listSize = jsonObject.getAsJsonArray("list").size();
            List<Float> tempValues = new ArrayList<>();

            for (int i = 0; i < listSize; i++) {
                tempValues.add(jsonObject.getAsJsonArray("list")
                        .get(i)
                        .getAsJsonObject()
                        .getAsJsonObject("main")
                        .get("temp")
                        .getAsFloat());
            }

            System.out.println("Temperature: " + tempValues);
            Weather weather = new Weather(getRain(), getClouds(), getTemp(), getHumidity(), getLocation(), ts);
            return weather;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
