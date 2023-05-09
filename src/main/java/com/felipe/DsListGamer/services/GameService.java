package com.felipe.DsListGamer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.DsListGamer.dto.GameDtoMin;
import com.felipe.DsListGamer.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository repository;
	
	public List<GameDtoMin> listAll(){
		return repository.findAll().stream().map(GameDtoMin::new).toList();
	}

}
