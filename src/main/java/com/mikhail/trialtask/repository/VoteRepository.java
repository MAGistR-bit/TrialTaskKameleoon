package com.mikhail.trialtask.repository;

import com.mikhail.trialtask.entity.Quote;
import com.mikhail.trialtask.entity.User;
import com.mikhail.trialtask.entity.Vote;
import com.mikhail.trialtask.entity.VoteType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    Vote findByQuoteAndVoteType(Quote quote, VoteType voteType);
    Vote findByQuoteAndUser(Quote quote, User user);
}
