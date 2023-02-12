package com.mikhail.trialtask.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User {

    /**
     * Идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Логин (имя пользователя)
     */
    @Column(name = "name", nullable = false)
    private String name;
    /**
     * Адрес электронной почты
     */
    @Column(name = "email",
            nullable = false,
            unique = true)
    private String email;
    /**
     * Пароль
     */
    @Column(name = "password", nullable = false)
    @ToString.Exclude
    private String password;

    /**
     * Дата создания
     */
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
