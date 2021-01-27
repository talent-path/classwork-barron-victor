package com.tp.connectFour.controllers;

import com.tp.connectFour.models.Board;
import com.tp.connectFour.services.ConnectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BoardController {
    @Autowired
    ConnectServices service;


    @GetMapping("/game/{gameId}")
    public Board getBoard(@PathVariable Integer gameId){
        Board thisOne = service.getBoardId(gameId);
        return thisOne;
    }

    @PostMapping("/game/")
    public Board makeMove(@RequestBody MoveRequest move){
        return service.makeMove(move.getGameId(), move.getColumn());
    }
}
