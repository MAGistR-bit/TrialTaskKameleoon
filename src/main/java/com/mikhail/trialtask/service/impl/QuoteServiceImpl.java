package com.mikhail.trialtask.service.impl;

import com.mikhail.trialtask.dto.QuoteDTO;
import com.mikhail.trialtask.dto.VoteDTO;
import com.mikhail.trialtask.entity.Quote;
import com.mikhail.trialtask.entity.User;
import com.mikhail.trialtask.exception.NotFoundResourceException;
import com.mikhail.trialtask.repository.QuoteRepository;
import com.mikhail.trialtask.repository.UserRepository;
import com.mikhail.trialtask.service.QuoteService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Реализация интерфейса QuoteService
 */
@Service
public class QuoteServiceImpl implements QuoteService {
    private final QuoteRepository quoteRepository;
    private final UserRepository userRepository;

    public QuoteServiceImpl(QuoteRepository quoteRepository, UserRepository userRepository) {
        this.quoteRepository = quoteRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Quote> getAllQuotes() {
        return quoteRepository.findAll();
    }

    @Override
    public Quote getQuoteById(Long id) {
        return quoteRepository.findById(id).orElseThrow(() ->
                new NotFoundResourceException("Цитата с идентификатором " + id +
                        " не найдена!"));
    }

    @Override
    public Quote getRandomQuote() {
        List<Quote> quotes = quoteRepository.findAll();
        int randomIndex = (int) (Math.random() * quotes.size());
        return quotes.get(randomIndex);
    }

    @Override
    public Quote createQuote(QuoteDTO quoteDTO) {
        User user = userRepository.findById(quoteDTO.getUser().getId()).orElseThrow(() ->
                new NotFoundResourceException("Пользователь с идентификатором " + quoteDTO.getUser().getId()
                + " не найден!"));
        Quote quote = new Quote();
        quote.setContent(quoteDTO.getContent());
        quote.setUser(user);
        quote.setCreatedAt(LocalDateTime.now());
        quote.setUpdatedAt(LocalDateTime.now());
        return quoteRepository.save(quote);
    }

    @Override
    public Quote updateQuote(Long id, QuoteDTO quoteDTO) {
        Quote quote = quoteRepository.findById(id).orElseThrow(() ->
                new NotFoundResourceException("Цитата с идентификатором " + id + " не найдена!"));

        quote.setContent(quoteDTO.getContent());
        quote.setUpdatedAt(LocalDateTime.now());
        return quoteRepository.save(quote);
    }
    @Override

    public void deleteQuote(Long id) {
        Quote quote = quoteRepository.findById(id).orElseThrow(() ->
                new NotFoundResourceException("Цитата с идентификатором " + id + "не найдена!"));
        quoteRepository.delete(quote);
    }

    @Override
    public Quote upvoteQuote(Long id, VoteDTO voteDTO) {
        Quote quote = quoteRepository.findById(id).orElseThrow(() ->
                new NotFoundResourceException("Цитата с идентификатором " + id + " не найдена!"));

        int vote = voteDTO.getVote();
        quote.setVotes(quote.getVotes() + vote);
        return quoteRepository.save(quote);
    }

    public Quote downvoteQuote(Long id, VoteDTO voteDTO) {
        Quote quote = quoteRepository.findById(id).orElseThrow(() ->
                new NotFoundResourceException("Цитата с идентификатором " + id + " не найдена!"));

        int vote = voteDTO.getVote();
        quote.setVotes(quote.getVotes() - vote);
        return quoteRepository.save(quote);
    }

    @Override
    public List<Quote> getTop10Quotes() {
        return quoteRepository.findTop10ByOrderByCreatedAtDesc();
    }

    @Override
    public List<Quote> getWorst10Quotes() {
        return quoteRepository.findTop10ByOrderByCreatedAtAsc();
    }

}