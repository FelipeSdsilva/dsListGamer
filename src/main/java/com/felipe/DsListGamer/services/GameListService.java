package com.felipe.DsListGamer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.felipe.DsListGamer.dto.GameListDTO;
import com.felipe.DsListGamer.projections.GameMinProjection;
import com.felipe.DsListGamer.repositories.GameListRepository;
import com.felipe.DsListGamer.repositories.GameRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository repository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> listAll(){
		return repository.findAll().stream().map(GameListDTO::new).toList();
	}

	public void move(Long listId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		
		GameMinProjection obj = list.remove(sourceIndex);
		
		list.add(destinationIndex, obj);
		
		
	}
}
