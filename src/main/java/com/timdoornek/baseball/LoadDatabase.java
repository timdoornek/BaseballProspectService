package com.timdoornek.baseball;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.timdoornek.baseball.domain.Player;
import com.timdoornek.baseball.repository.PlayerRepository;

@Configuration
public class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(PlayerRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new Player("123", "Tim D. Doornek", "C", LocalDate.of(1994, 6, 1), "TR")));
    log.info("We out here");
    };
  }
}
