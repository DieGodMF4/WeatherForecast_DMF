package marrero_ferrera_gcid_ulpgc.test.model;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.SQLException;

public interface WeatherStore {
    Connection connectWeather();
    void createTable(Connection connection) throws SQLException;
    void insertWeather(Weather weather);
}
