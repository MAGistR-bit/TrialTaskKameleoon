package com.mikhail.trialtask.controller;

import com.mikhail.trialtask.dto.QuoteDTO;
import com.mikhail.trialtask.dto.VoteDTO;
import com.mikhail.trialtask.entity.Quote;
import com.mikhail.trialtask.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Данный класс отвечает за Mapping
 */
@RestController
@RequestMapping("/api/v1")
public class QuoteController {
    private final QuoteService quoteService;

    @Autowired
    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping("/quotes")
    public ResponseEntity<List<Quote>> getAllQuotes() {
        List<Quote> quotes = quoteService.getAllQuotes();
        return new ResponseEntity<>(quotes, HttpStatus.OK);
    }

    @GetMapping("/quotes/{id}")
    public ResponseEntity<Quote> getQuoteById(@PathVariable Long id) {
        Quote quote = quoteService.getQuoteById(id);
        return new ResponseEntity<>(quote, HttpStatus.OK);
    }

    @GetMapping("/quotes/random")
    public ResponseEntity<Quote> getRandomQuote() {
        Quote quote = quoteService.getRandomQuote();
        return new ResponseEntity<>(quote, HttpStatus.OK);
    }

    @PostMapping("/quotes")
    public ResponseEntity<Quote> createQuote(@RequestBody QuoteDTO quoteDTO) {
        Quote quote = quoteService.createQuote(quoteDTO);
        return new ResponseEntity<>(quote, HttpStatus.CREATED);
    }

    @PutMapping("/quotes/{id}")
    public ResponseEntity<Quote> updateQuote(@PathVariable Long id, @RequestBody QuoteDTO quoteDTO) {
        Quote quote = quoteService.updateQuote(id, quoteDTO);
        return new ResponseEntity<>(quote, HttpStatus.OK);
    }

    @DeleteMapping("/quotes/{id}")
    public ResponseEntity<Void> deleteQuote(@PathVariable Long id) {
        quoteService.deleteQuote(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/quotes/{id}/vote")
    public ResponseEntity<Quote> voteOnQuote(@PathVariable Long id, @RequestBody VoteDTO voteDTO) {
        Quote quote = quoteService.upvoteQuote(id, voteDTO);
        return new ResponseEntity<>(quote, HttpStatus.OK);
    }

    @PostMapping("/quotes/{id}/downvote")
    public ResponseEntity<Quote> downvoteQuote(@PathVariable Long id, @RequestBody VoteDTO voteDTO) {
        Quote quote = quoteService.downvoteQuote(id, voteDTO);
        return new ResponseEntity<>(quote, HttpStatus.OK);
    }

    @GetMapping("/quotes/top10")
    public ResponseEntity<List<Quote>> getTop10Quotes() {
        List<Quote> quotes = quoteService.getTop10Quotes();
        return new ResponseEntity<>(quotes, HttpStatus.OK);
    }

    @GetMapping("/quotes/worst10")
    public ResponseEntity<List<Quote>> getWorst10Quotes() {
        List<Quote> quotes = quoteService.getWorst10Quotes();
        return new ResponseEntity<>(quotes, HttpStatus.OK);
    }
}
