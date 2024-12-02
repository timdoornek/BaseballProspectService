package com.timdoornek.baseball.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.timdoornek.baseball.domain.Player;

public interface PlayerRepository extends JpaRepository<Player, String> {
    
}
