package com.timdoornek.baseball.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timdoornek.baseball.domain.Player;
import com.timdoornek.baseball.exception.BaseballProspectsException;
import com.timdoornek.baseball.exception.InvalidInputException;
import com.timdoornek.baseball.repository.AcquisitionTypeRepository;
import com.timdoornek.baseball.repository.PlayerRepository;
import com.timdoornek.baseball.utlity.ApplicationConstants;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private AcquisitionTypeRepository acquisitionTypeRepository;

	@Override
	public Player upsertPlayer(Player player) throws BaseballProspectsException {
		this.validatePlayer(player);

		Player addedPlayer = playerRepository.save(player);

		return addedPlayer;
	}

	@Override
	public Player findPlayerById(String id) {
		Optional<Player> player = playerRepository.findById(id);

		Player myReturn = null;
		if (player.isPresent()) {
			myReturn = player.get();
		}

		return myReturn;
	}

	private void validatePlayer(Player player) throws BaseballProspectsException {
		StringBuilder myErrorMessageStringBuilder = new StringBuilder();

		if (player == null) {
			myErrorMessageStringBuilder.append(ApplicationConstants.INVALID_PLAYER_NULL_MESSAGE);
		} else {
			if (player.getId() == null) {
				myErrorMessageStringBuilder.append(ApplicationConstants.INVALID_PLAYER_ID_MESSAGE);
			}
			if (player.getName() == null || player.getName().isBlank() || player.getName().length() > 255) {
				myErrorMessageStringBuilder.append(ApplicationConstants.INVALID_PLAYER_NAME_MESSAGE);
			}
			if (player.getPosition() == null || player.getPosition().isBlank() || player.getPosition().length() > 20) {
				myErrorMessageStringBuilder.append(ApplicationConstants.INVALID_PLAYER_POSITION_MESSAGE);
			}
			if (player.getDob() == null) {
				myErrorMessageStringBuilder.append(ApplicationConstants.INVALID_PLAYER_DOB_MESSAGE);
			}
			List<String> myValidAcquisitionTypeCodes = acquisitionTypeRepository.findAll().stream()
					.map(a -> a.getCode()).toList();
			if (player.getAcquisitionTypeCd() == null
					|| !myValidAcquisitionTypeCodes.stream().anyMatch(a -> a.equals(player.getAcquisitionTypeCd()))) {
				myErrorMessageStringBuilder.append(ApplicationConstants.INVALID_PLAYER_ACQUISITION_TYPE_CODE_MESSAGE);
			}

		}

		if (!myErrorMessageStringBuilder.isEmpty()) {
			throw new InvalidInputException(myErrorMessageStringBuilder.toString());
		}
	}
}
