package com.timdoornek.baseball.service;

import org.springframework.stereotype.Service;

import com.timdoornek.baseball.domain.Player;
import com.timdoornek.baseball.exception.BaseballProspectsException;

@Service
public interface PlayerService {
		public Player upsertPlayer(Player player) throws BaseballProspectsException;
		public Player findPlayerById(String id);
}
