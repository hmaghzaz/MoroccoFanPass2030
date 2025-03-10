package com.morocco.fanPass.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.morocco.fanPass.entity.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
}
