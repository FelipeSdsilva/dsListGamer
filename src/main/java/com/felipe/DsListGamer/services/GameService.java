package com.felipe.DsListGamer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.felipe.DsListGamer.dto.GameDTO;
import com.felipe.DsListGamer.dto.GameMinDTO;
import com.felipe.DsListGamer.entities.Game;
import com.felipe.DsListGamer.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository repository;
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> listAll(){
		return repository.findAll().stream().map(GameMinDTO::new).toList();
	}

	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game game = repository.findById(id).orElseThrow();
		return new GameDTO(game);
	}

}
