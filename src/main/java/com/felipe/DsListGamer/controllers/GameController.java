package com.felipe.DsListGamer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipe.DsListGamer.dto.GameDtoMin;
import com.felipe.DsListGamer.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {
	
	@Autowired
	private GameService service;
	
	@GetMapping
	public ResponseEntity<List<GameDtoMin>> findAll(){
		 List<GameDtoMin> listGame = service.listAll();
		 return ResponseEntity.ok().body(listGame);
	}

	
}
