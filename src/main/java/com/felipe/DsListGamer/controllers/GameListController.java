package com.felipe.DsListGamer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipe.DsListGamer.dto.GameListDTO;
import com.felipe.DsListGamer.dto.GameMinDTO;
import com.felipe.DsListGamer.services.GameListService;
import com.felipe.DsListGamer.services.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
	
	@Autowired
	private GameListService service;
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public ResponseEntity<List<GameListDTO>> findAll(){
		List<GameListDTO> list = service.listAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "{listId}/games")
	public ResponseEntity<List<GameMinDTO>> listGamePerLisId(@PathVariable Long listId){
		 List<GameMinDTO> listGames = gameService.findByList(listId);
		 return ResponseEntity.ok().body(listGames);
	}
	

}
