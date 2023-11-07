package marrero_ferrera_gcid_ulpgc.test.model;

import java.time.Instant;
import java.util.List;

public interface WeatherSupplier {
    Weather getWeather(Location location, Instant ts);
    /*
    float getTemp();
    float getRain();
    int getClouds();
    float getHumidity();
*/
}
