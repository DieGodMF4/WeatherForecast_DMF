package marrero_ferrera_gcid_ulpgc.test.model;

import java.time.Instant;

public class Weather {
    private Instant ts;
    private String weatherType;
    private int clouds;
    private float temperature;
    private float rain;
    private float humidity;
    private Location location;

    public Weather(String weatherType, int clouds, float temperature, float humidity, Location location, Instant ts, float rain) {
        this.weatherType = weatherType;
        this.clouds = clouds;
        this.temperature = temperature;
        this.humidity = humidity;
        this.location = location;
        this.ts = ts;
        this.rain = rain;
    }

    public int getClouds() {
        return clouds;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public Location getLocation() {
        return location;
    }

    public String getTsToString() {
        return ts.toString();
    }

    public String getWeatherType() {
        return weatherType;
    }

    public float getRain() {
        return rain;
    }

}
