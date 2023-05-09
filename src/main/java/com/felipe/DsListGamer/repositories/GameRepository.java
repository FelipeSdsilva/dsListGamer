package com.felipe.DsListGamer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.felipe.DsListGamer.entities.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long>{

}
