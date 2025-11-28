package hu.gamf.javalabproject.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "radios")
public class Radio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "town_name")
    private String townName;
    private String name;
    private Double frequency;
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

    public int getId() {
        return id;
    }

    public String getTownName() {
        return townName;
    }

    public String getName() {
        return name;
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
    public LocalDateTime getModifiedAt() { return modifiedAt; }

    public void setId(int id) {
        this.id = id;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }



    public void setFrequency(Double frequency) {
        this.frequency = frequency;
    }

    public void setPower(Double power) {
        this.power = power;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    @Override
    public String toString() {
        return "Radio{" +
                "id=" + id +
                ", townName='" + townName + '\'' +
                ", frequency=" + frequency +
                ", power=" + power +
                ", address='" + address + '\'' +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                '}';
    }
}
