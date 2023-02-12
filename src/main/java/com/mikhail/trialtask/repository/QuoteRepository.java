package com.mikhail.trialtask.repository;

import com.mikhail.trialtask.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
    /**
     * Находит 10 цитат, отсортировав данные по дате
     * создания (по убыванию)
     * @return список цитат
     */
    List<Quote> findTop10ByOrderByCreatedAtDesc();
    /**
     * Находит 10 цитат, отсортировав данные
     * по дате создания (по возрастанию)
     * @return список цитат
     */
    List<Quote> findTop10ByOrderByCreatedAtAsc();
}
