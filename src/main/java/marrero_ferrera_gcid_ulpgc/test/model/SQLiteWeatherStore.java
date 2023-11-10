package marrero_ferrera_gcid_ulpgc.test.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLiteWeatherStore implements WeatherStore {
    @Override
    public void createTable() {

        final String DATABASE_URL = "jdbc:sqlite:./IdeaProjects/practice1_v2/sqlite/java";
        // C:\Users\dmarr\IdeaProjects\practice1_v2\src\main\java\marrero_ferrera_gcid_ulpgc\test\model

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement statement = connection.prepareStatement(
                     "CREATE TABLE IF NOT EXISTS weather_table (" +
                             "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                             "location TEXT," +
                             "temperature REAL" +
                             // Add other columns as needed
                             ");")) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public void insertWeather(Weather weather) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO weather_table (location, temperature) VALUES (?, ?);")) {
            statement.setString(1, weather.getLocation());
            statement.setDouble(2, weather.getTemperature());
            // Set other parameters as needed
            statement.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }
}
