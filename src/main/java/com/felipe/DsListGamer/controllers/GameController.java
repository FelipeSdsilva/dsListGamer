package com.felipe.DsListGamer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipe.DsListGamer.dto.GameDTO;
import com.felipe.DsListGamer.dto.GameMinDTO;
import com.felipe.DsListGamer.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {
	
	@Autowired
	private GameService service;
	
	@GetMapping
	public ResponseEntity<List<GameMinDTO>> findAll(){
		 List<GameMinDTO> listGame = service.listAll();
		 return ResponseEntity.ok().body(listGame);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<GameDTO> findById(@PathVariable Long id){
		 GameDTO game = service.findById(id);
		 return ResponseEntity.ok().body(game);
	}

	
}
