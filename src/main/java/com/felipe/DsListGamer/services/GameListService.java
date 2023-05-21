package com.felipe.DsListGamer.services;

import com.felipe.DsListGamer.dto.GameListDTO;
import com.felipe.DsListGamer.projections.GameMinProjection;
import com.felipe.DsListGamer.repositories.GameListRepository;
import com.felipe.DsListGamer.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

	@Autowired
	private GameListRepository repository;

	@Autowired
	private GameRepository gameRepository;

	@Transactional(readOnly = true)
	public List<GameListDTO> listAll() {
		return repository.findAll().stream().map(GameListDTO::new).toList();
	}

	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> list = gameRepository.searchByList(listId);

		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);

		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

		for (int i = min; i <= max; i++) {
			repository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}

	}
}
