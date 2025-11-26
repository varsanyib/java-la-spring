package hu.gamf.javalabproject.models;

import java.time.LocalDateTime;

public class RadioDTO {
    private Long id;
    private String name;
    private String townName;
    private String countyName;
    private String region;
    private Double frequency;
    private Double power;
    private String address;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public RadioDTO(Long id, String name, String townName, String countyName, String region,
                     Double frequency, Double power, String address,
                     LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.townName = townName;
        this.countyName = countyName;
        this.region = region;
        this.frequency = frequency;
        this.power = power;
        this.address = address;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getTownName() { return townName; }
    public String getCountyName() { return countyName; }
    public String getRegion() { return region; }
    public Double getFrequency() { return frequency; }
    public Double getPower() { return power; }
    public String getAddress() { return address; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}
