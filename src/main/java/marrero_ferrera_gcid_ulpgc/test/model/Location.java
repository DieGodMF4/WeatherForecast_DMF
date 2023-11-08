package marrero_ferrera_gcid_ulpgc.test.model;

public class Location {
    private float latitude;
    private float longitude;
    private String island;
    private String name;

    public Location(float latitude, float longitude, String island, String name) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.island = island;
        this.name = name;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getIsland() {
        return island;
    }

    public void setIsland(String island) {
        this.island = island;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
