package com.mikhail.trialtask.repository;

import com.mikhail.trialtask.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Получить пользователя по email
     * @param email адрес электронной почты
     * @return пользователь
     */
    User findByEmail(String email);
}
