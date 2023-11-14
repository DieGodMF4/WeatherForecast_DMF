package marrero_ferrera_gcid_ulpgc.test.control;

import marrero_ferrera_gcid_ulpgc.test.model.Location;
import marrero_ferrera_gcid_ulpgc.test.model.WeatherController;

import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.TimerTask;

public class Task extends TimerTask {
    private Location location;
    private String  apiKey;
    private String dbPath;
    public Task(Location location, String apiKey, String dbPath) {
        this.location = location;
        this.apiKey = apiKey;
        this.dbPath = dbPath;
    }

    @Override
    public void run() {
        LocalDateTime now = LocalDateTime.now();

        LocalDateTime scheduledTime = now.withHour(12).withMinute(0).withSecond(0).withNano(0);

        if (now.isAfter(scheduledTime)) {
            scheduledTime = scheduledTime.plusDays(1);
        }

        WeatherController controller = new WeatherController();

        for (int i = 0; i < 5; i++) {
            LocalDateTime nextExecutionTime = scheduledTime.plusDays(i);
            Instant instant = nextExecutionTime.atZone(ZoneId.systemDefault()).toInstant();

            try {
                controller.getAndStoreWeatherData(location, apiKey, dbPath, instant);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
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

    public String getDbPath() {
        return dbPath;
    }

    public void setDbPath(String dbPath) {
        this.dbPath = dbPath;
    }
}
