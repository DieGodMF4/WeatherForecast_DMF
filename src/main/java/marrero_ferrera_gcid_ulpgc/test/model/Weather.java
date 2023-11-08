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

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Instant getTs() {
        return ts;
    }

    public void setTs(Instant ts) {
        this.ts = ts;
    }

    public String getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(String weatherType) {
        this.weatherType = weatherType;
    }

    public float getRain() {
        return rain;
    }

    public void setRain(float rain) {
        this.rain = rain;
    }

    @Override
    public String toString() {
        return "The weather in " + getLocation().getName() + ", " + getLocation().getIsland() + ", can be defined with " + getWeatherType() + " at " + getTs() +
                ".\nThe temperature is " + getTemperature() + "ºC with a " + getHumidity() + "% of humidity" +
                "; we have a " + getClouds() + "% of clouds and a " + getRain() + "% rate of precipitations.";
    }
}
