package hu.gamf.javalabproject.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "radios")
public class Radio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "town_name")
    @NotNull
    private String townName;
    @NotNull
    private String name;
    @NotNull
    @Min(0)
    private Double frequency;
    @NotNull
    @Min(0)
    private Double power;
    private String address;
    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at", insertable = false, updatable = false)
    private LocalDateTime modifiedAt;

    public Radio(int id, String townName, String name, Double frequency, Double power, String address, LocalDateTime createdAt,  LocalDateTime modifiedAt) {
        this.id = id;
        this.townName = townName;
        this.name = name;
        this.frequency = frequency;
        this.power = power;
        this.address = address;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Radio() {
    }

    public Radio(String townName, String name, Double frequency, Double power, String address) {
        this.townName = townName;
        this.name = name;
        this.frequency = frequency;
        this.power = power;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getFrequency() {
        return frequency;
    }

    public void setFrequency(Double frequency) {
        this.frequency = frequency;
    }

    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
