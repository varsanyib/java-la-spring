package hu.gamf.javalabproject.models;

import java.time.LocalDateTime;

public class NewestRadioDTO {
    private String name;
    private String townName;
    private Double frequency;
    private Double power;
    private String address;
    private LocalDateTime createdAt;

    public NewestRadioDTO(String name, String townName,
                          Double frequency, Double power,
                          String address, LocalDateTime createdAt) {
        this.name = name;
        this.townName = townName;
        this.frequency = frequency;
        this.power = power;
        this.address = address;
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public String getTownName() {
        return townName;
    }

    public Double getFrequency() {
        return frequency;
    }

    public Double getPower() {
        return power;
    }

    public String getAddress() {
        return address;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
