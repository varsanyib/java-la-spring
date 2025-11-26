package hu.gamf.javalabproject.models;

import java.time.LocalDateTime;

public class MessageDTO {
    private String name;
    private String username;
    private String subject;
    private String body;
    private LocalDateTime createdAt;

    public MessageDTO(String name, String username,
                       String subject, String body,
                       LocalDateTime createdAt) {
        this.name = name;
        this.username = username;
        this.subject = subject;
        this.body = body;
        this.createdAt = createdAt;
    }

    public String getName() { return name; }
    public String getUsername() { return username; }
    public String getSubject() { return subject; }
    public String getBody() { return body; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
