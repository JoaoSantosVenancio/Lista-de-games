package com.JaoDosCos.listaGames.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JaoDosCos.listaGames.entities.Game;

public interface GameRepositories extends JpaRepository<Game, Long>{
	 
}
