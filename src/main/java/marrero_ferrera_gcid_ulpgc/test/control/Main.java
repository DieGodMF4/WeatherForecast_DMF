package marrero_ferrera_gcid_ulpgc.test.control;

import marrero_ferrera_gcid_ulpgc.test.model.*;

import java.sql.SQLException;
import java.util.Timer;

public class Main {
    public static void main(String[] args) throws SQLException {
        Location locationGC = new Location(28.01f, -15.58f, "Gran Canaria", "Risco Prieto");
        Location locationLGra = new Location(29.234f, -13.5f, "La Graciosa", "Caleta del Sebo");
        Location locationLzr = new Location(29f,  -13.5f, "Lanzarote", "Costa Teguise");
        Location locationFtv = new Location(28.35f,  -14.11f, "Fuerteventura", "Pájara");
        Location locationLGom = new Location(28.1f,  -17.12f, "La Gomera", "San Sebastián de La Gomera");
        Location locationLP = new Location(28.8f,  -17.81f, "La Palma", "Bosque de Los Tilos");
        Location locationEH = new Location(27.73f,  -18.05f, "El Hierro", "El Pinar");
        Location locationTnf = new Location(28.28f,  -16.64f, "Tenerife", "Parque Nacional del Teide");

        String apiKey = "3c3aea5ce433b076c2f83b0c608896d8";
        String dbPath = "weatherDataBase.db";

        Timer timer = new Timer();
        short delay = 0;
        long period = 6 * 60 * 60 * 1000;

        timer.scheduleAtFixedRate(new Task(locationGC, apiKey, dbPath), delay, period);
        timer.scheduleAtFixedRate(new Task(locationLGra, apiKey, dbPath), delay, period);
        timer.scheduleAtFixedRate(new Task(locationLzr, apiKey, dbPath), delay, period);
        timer.scheduleAtFixedRate(new Task(locationFtv, apiKey, dbPath), delay, period);
        timer.scheduleAtFixedRate(new Task(locationLGom, apiKey, dbPath), delay, period);
        timer.scheduleAtFixedRate(new Task(locationLP, apiKey, dbPath), delay, period);
        timer.scheduleAtFixedRate(new Task(locationEH, apiKey, dbPath), delay, period);
        timer.scheduleAtFixedRate(new Task(locationTnf, apiKey, dbPath), delay, period);
    }
}