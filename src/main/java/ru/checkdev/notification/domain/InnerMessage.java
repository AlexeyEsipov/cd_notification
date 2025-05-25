package ru.checkdev.notification.domain;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

//@Data
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder(builderMethodName = "of")
@Entity(name = "cd_message")
@Getter
@Setter
public class InnerMessage implements Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int userId;
    private String text;
    private Timestamp created;
    private boolean read;
    private int interviewId;

    public InnerMessage(int id, int userId, String text, Timestamp created, boolean read) {
        this.id = id;
        this.userId = userId;
        this.text = text;
        this.created = created;
        this.read = read;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InnerMessage that = (InnerMessage) o;
        return id == that.id && userId == that.userId && read == that.read && interviewId == that.interviewId && Objects.equals(text, that.text) && Objects.equals(created, that.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, text, created, read, interviewId);
    }

    @Override
    public void setId(int id) {

    }
}
