package hu.gamf.javalabproject.models;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "messages")
public class ContactDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    @Size(min = 4, max = 20)
    private String fullname;
    @NotNull
    @Size(min = 5, max = 50)
    private String subject;
    @NotNull
    @Size(min = 10, max = 1000)
    private String message;

    public ContactDTO() {
    }

    public ContactDTO(String fullname, String subject, String message) {
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

    @Override
    public String toString() {
        return "ContactDTO{" +
                "fullname='" + fullname + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
