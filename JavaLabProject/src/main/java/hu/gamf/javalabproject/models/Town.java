package hu.gamf.javalabproject.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "towns")
public class Town {
    @Id
    private String name;
    @Column(name = "county_name")
    private String countyName;
    @Column(name = "created_at",  insertable = false, updatable = false)
    LocalDateTime createdAt;
    @Column(name = "updated_at",   insertable = false, updatable = false)
    LocalDateTime modifiedAt;

    public Town() {
    }

    public Town(String name, String countyName, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.name = name;
        this.countyName = countyName;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
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

    @Override
    public String toString() {
        return "Town{" +
                "name='" + name + '\'' +
                ", countyName='" + countyName + '\'' +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                '}';
    }
}
