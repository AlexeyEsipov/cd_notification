package ru.checkdev.notification.domain;

//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "cd_user_telegram")
public class UserTelegram implements Base {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_id", nullable = false, unique = true)
    private int userId;
    @Column(name = "chat_id", nullable = false, unique = true)
    private long chatId;
    private boolean notifiable;

    @Override
    public void setId(int id) {

    }
}