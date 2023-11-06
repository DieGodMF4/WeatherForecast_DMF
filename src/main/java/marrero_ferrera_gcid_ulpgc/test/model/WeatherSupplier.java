package marrero_ferrera_gcid_ulpgc.test.model;

import marrero_ferrera_gcid_ulpgc.test.model.*;

import java.time.Instant;

public interface WeatherSupplier {
    Weather getWeather(Location location, Instant ts);
    /*
    float getTemp();
    float getRain();
    int getClouds();
    float getHumidity();
*/
}
