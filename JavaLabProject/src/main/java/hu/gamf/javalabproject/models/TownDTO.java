package hu.gamf.javalabproject.models;

public class TownDTO {
    private String name;
    private String countyName;

    public TownDTO(String name, String countyName) {
        this.name = name;
        this.countyName = countyName;
    }

    public String getName() { return name; }
    public String getCountyName() { return countyName; }
}
