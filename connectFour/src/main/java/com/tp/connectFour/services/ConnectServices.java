package com.tp.connectFour.services;

import com.tp.connectFour.models.Board;
import com.tp.connectFour.persistence.ConnectMemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConnectServices {

    @Autowired
    ConnectMemDao dao;

    public Board getBoardId(Integer boardId) {
        return dao.getBoardbyId(boardId);
    }

    public Board makeMove(int gameId, int column) {

        Board game = dao.getBoardbyId(gameId);
//        for(int i = 6 game.getBoard()){
//            if(row[column] != 0){
//
//            }
//        }

    }






}
