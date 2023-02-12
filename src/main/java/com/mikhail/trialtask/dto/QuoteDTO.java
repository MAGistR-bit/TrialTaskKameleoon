package com.mikhail.trialtask.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class QuoteDTO {
    /**
     * Идентификатор
     */
    private Long id;
    /**
     * Контент
     */
    private String content;
    /**
     * Дата создания
     */
    private LocalDateTime createdAt;
    /**
     * Дата обновления
     */
    private LocalDateTime updatedAt;
    /**
     * Данные о пользователе
     */
    private UserDTO user;
}
