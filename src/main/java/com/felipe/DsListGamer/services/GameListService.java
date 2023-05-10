package com.felipe.DsListGamer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.felipe.DsListGamer.dto.GameListDTO;
import com.felipe.DsListGamer.repositories.GameListRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository repository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> listAll(){
		return repository.findAll().stream().map(GameListDTO::new).toList();
	}

}
