package marrero_ferrera_gcid_ulpgc.test.model;

import java.time.Instant;
import java.util.List;

public interface WeatherSupplier {
    List<Weather> getWeather(Location location, List<Instant> ts);
    /*
    float getTemp();
    float getRain();
    int getClouds();
    float getHumidity();
*/
}
