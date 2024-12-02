package com.timdoornek.baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.timdoornek.baseball.domain.Player;
import com.timdoornek.baseball.exception.BaseballProspectsException;
import com.timdoornek.baseball.exception.InvalidInputException;
import com.timdoornek.baseball.service.PlayerService;
import com.timdoornek.baseball.utlity.ApplicationConstants;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
class BaseballProspectsApplicationTests {

	@Autowired
	private PlayerService playerService;

	private Player validPlayerWithNulls;
	private Player validPlayerNoNulls;
	private Player invalidPlayerInvalidAcquisitionTypeCd;
	private Player invalidPlayerNoId;

	@BeforeAll
	private void initializePlayers() {
		validPlayerWithNulls = new Player("123", "Valid PlayerWithNulls", "C", LocalDate.of(2000, 2, 3), "TR");
		validPlayerNoNulls = new Player("1", "Slats Maloone", "RHP", LocalDate.of(1999, 1, 2), "Mukwonago", 100, 200,
				"FA", "www.google.com", "R", "R", "Rd 1 Pk 1 - MIL");
		invalidPlayerInvalidAcquisitionTypeCd = new Player("2", "Slats Maloone", "RHP", LocalDate.of(1999, 1, 2),
				"Mukwonago", 100, 200, "ZZ", "www.google.com", "R", "R", "Rd 1 Pk 1 - MIL");
		invalidPlayerNoId = new Player(null, "Valid PlayerWithNulls", "C", LocalDate.of(2000, 2, 3), "TR");
	}

	@Test
	void contextLoads() {
		assertTrue(true);
	}

	@Test
	void addPlayerValidWithNulls() throws BaseballProspectsException {
		Player myReturn = playerService.upsertPlayer(validPlayerWithNulls);

		assertNotNull(myReturn);
		assertEquals(validPlayerWithNulls, myReturn);
	}

	@Test
	void addPlayerValidNoNulls() throws BaseballProspectsException {
		Player myReturn = playerService.upsertPlayer(validPlayerNoNulls);

		assertNotNull(myReturn);
		assertEquals(validPlayerNoNulls, myReturn);
	}

	@Test
	void addPlayerInvalidPlayerInvalidAcquisitionTypeCd() {
		BaseballProspectsException myException = assertThrows(InvalidInputException.class,
				() -> playerService.upsertPlayer(invalidPlayerInvalidAcquisitionTypeCd));

		assertTrue(
				myException.getMessage().contains(ApplicationConstants.INVALID_PLAYER_ACQUISITION_TYPE_CODE_MESSAGE));
	}

	@Test
	void addPlayerInvalidNullPlayer() {
		BaseballProspectsException myException = assertThrows(InvalidInputException.class,
				() -> playerService.upsertPlayer(null));

		assertTrue(myException.getMessage().contains(ApplicationConstants.INVALID_PLAYER_NULL_MESSAGE));
	}

	@Test
	void addPlayerInvalidNullIds() {
		BaseballProspectsException myException = assertThrows(InvalidInputException.class,
				() -> playerService.upsertPlayer(invalidPlayerNoId));

		assertTrue(myException.getMessage().contains(ApplicationConstants.INVALID_PLAYER_ID_MESSAGE));
	}

}
