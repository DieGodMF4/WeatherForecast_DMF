package marrero_ferrera_gcid_ulpgc.test.model;

import java.sql.*;

public class SQLiteWeatherStore implements WeatherStore {
    private final String dbPath;

    public SQLiteWeatherStore(String dbPath) {
        this.dbPath = dbPath;
    }

    @Override
    public Connection connectWeather() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:" + dbPath;
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
            return conn;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    @Override
    public void createTable(Connection connection) throws SQLException {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS weatherDataBase (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," + "\n" +
                    "latitude REAL," + "\n" +
                    "longitude REAL," + "\n" +
                    "island TEXT," + "\n" +
                    "name_place TEXT," + "\n" +
                    "time INTEGER," + "\n" +
                    "weatherType TEXT," + "\n" +
                    "temperature REAL," + "\n" +
                    "rain REAL," + "\n" +
                    "humidity REAL," + "\n" +
                    "clouds INTEGER" +
                    ");");
    }

    @Override
    public void insertWeather(Weather weather) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:weatherDataBase.db");
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO weatherDataBase (latitude, longitude, island, name_place, time, weatherType, temperature, rain, humidity, clouds) " +
                             "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            statement.setDouble(1, weather.getLocation().getLatitude());
            statement.setDouble(2, weather.getLocation().getLongitude());
            statement.setString(3, weather.getLocation().getIsland());
            statement.setString(4, weather.getLocation().getName());
            statement.setLong(5, weather.getTimeInteger());
            statement.setString(6, weather.getWeatherType());
            statement.setDouble(7, weather.getTemperature());
            statement.setDouble(8, weather.getRain());
            statement.setDouble(9, weather.getHumidity());
            statement.setInt(10, weather.getClouds());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public String getDbPath() {
        return dbPath;
    }
}
