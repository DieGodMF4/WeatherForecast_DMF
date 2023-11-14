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
    public void insertWeather(Weather weather) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + dbPath)) {
             if(!weatherExists(connection, weather)) {
            String query = "INSERT INTO weatherDataBase(id, latitude, longitude, island, name_place, time, weatherType, temperature, rain, humidity, clouds) " +
                    "VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {

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
                System.out.println("Weather data inserted succesfully.");
            }
        } else {
            System.out.println("Weather object already exists in the database.");
        }
    } catch (SQLException e) {
        e.getMessage();
    }
}

    @Override
    public boolean weatherExists(Connection connection, Weather weather) throws SQLException {
        String checkQuery = "SELECT COUNT(*) FROM weatherDataBase WHERE latitude = ? AND longitude = ? AND time = ?";
        try (PreparedStatement checkStatement = connection.prepareStatement(checkQuery)) {
            checkStatement.setFloat(1, weather.getLocation().getLatitude());
            checkStatement.setFloat(2, weather.getLocation().getLongitude());
            checkStatement.setLong(3, weather.getTimeInteger());

            try (ResultSet resultSet = checkStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    public String getDbPath() {
        return dbPath;
    }
}
