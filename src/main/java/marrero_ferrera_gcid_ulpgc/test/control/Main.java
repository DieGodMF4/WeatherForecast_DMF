package marrero_ferrera_gcid_ulpgc.test.control;

import marrero_ferrera_gcid_ulpgc.test.model.*;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.TimerTask;
import java.util.Timer;
import java.time.Instant;

public class Main {

    public static void main(String[] args) throws SQLException {
        Location locationGC = new Location(28.01f, -15.58f, "Gran Canaria", "Risco Prieto");
        Location locationLGra = new Location(29.234f, -13.5f, "La Graciosa", "Caleta del Sebo");
        Location locationLzr = new Location(29f,  -13.5f, "Lanzarote", "Costa Teguise");

        String apiKey = "3c3aea5ce433b076c2f83b0c608896d8";
        String dbPath = "weatherDataBase.db";

        Timer timer = new Timer();

        long delay = 0;
        long period = 6 * 1000;
        timer.scheduleAtFixedRate(new MyTask(locationGC, apiKey, dbPath), delay, period);
    }

    static class MyTask extends TimerTask {
        private Location location;
        private String  apiKey;
        private String dbPath;
        public MyTask(Location location, String apiKey, String dbPath) {
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
}