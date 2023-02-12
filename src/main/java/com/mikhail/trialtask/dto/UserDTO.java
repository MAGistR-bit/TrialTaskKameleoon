package com.mikhail.trialtask.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {
    /**
     * Идентификатор
     */
    private Long id;
    /**
     * Имя пользователя
     */
    private String name;
    /**
     * Адрес электронной почты
     */
    private String email;
    /**
     * Пароль
     */
    private String password;
    /**
     * Дата создания
     */
    private LocalDateTime createdAt;
}
