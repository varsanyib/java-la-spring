package hu.gamf.javalabproject.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class MessageDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fullname;
    private String subject;
    private String message;
    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "modified_at", insertable = false, updatable = false)
    private LocalDateTime modifiedAt;

    public MessageDTO() {
    }

    public MessageDTO(int id, String fullname, String subject, String message, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.fullname = fullname;
        this.subject = subject;
        this.message = message;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public MessageDTO(String fullname, String subject, String message) {
        this.fullname = fullname;
        this.subject = subject;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
        return "MessageDTO{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                '}';
    }
}
