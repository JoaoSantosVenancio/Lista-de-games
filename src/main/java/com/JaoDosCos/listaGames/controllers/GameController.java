package com.JaoDosCos.listaGames.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JaoDosCos.listaGames.entities.Game;
import com.JaoDosCos.listaGames.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	public List<Game> findAll(){
		
	}
}
