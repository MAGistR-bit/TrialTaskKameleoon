package com.mikhail.trialtask.service;

import com.mikhail.trialtask.dto.QuoteDTO;
import com.mikhail.trialtask.dto.VoteDTO;
import com.mikhail.trialtask.entity.Quote;
import com.mikhail.trialtask.service.impl.QuoteServiceImpl;

import java.util.List;

/**
 * Интерфейс
 * @see QuoteServiceImpl
 */
public interface QuoteService {
    /**
     * Добавить цитату
     * @return новая цитата
     */
    Quote createQuote(QuoteDTO quoteDTO);
    /**
     * Получить все цитаты
     * @return список цитат
     */
    List<Quote> getAllQuotes();
    /**
     * Получить лучшие цитаты
     * @return 10 лучших цитат
     */
    List<Quote> getTop10Quotes();
    /**
     * Получить худшие цитаты
     * @return 10 худших цитат
     */
    List<Quote> getWorst10Quotes();
    /**
     * Получить случайную цитату
     * @return случайная цитата
     */
    Quote getRandomQuote();
    /**
     * Редактировать цитату
     * @param id идентификатор цитаты
     * @param quoteDTO новое содержимое
     * @return отредактированная цитата
     */
    Quote updateQuote(Long id, QuoteDTO quoteDTO);
    /**
     * Удалить цитату
     * @param id идентификатор цитаты
     */
    void deleteQuote(Long id);
    /**
     * Понизить рейтинг цитаты
     * @param id идентификатор цитаты
     * @param voteDTO голос пользователя
     * @return цитата, у которой был понижен рейтинг
     */
    Quote downvoteQuote(Long id, VoteDTO voteDTO);
    /**
     * Найти цитату по ID
     * @param id идентификатор цитаты
     * @return цитата, которую ищет пользователь
     */
    Quote getQuoteById(Long id);

    /**
     * Повысить рейтинг цитаты
     * @param id идентификатор цитаты
     * @param voteDTO голосо пользователя
     * @return цитата, у которой был повышен рейтинг
     */
    Quote upvoteQuote(Long id, VoteDTO voteDTO);
}
