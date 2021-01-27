package com.tp.connectFour.persistence;

import com.tp.connectFour.models.Board;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConnectMemDao implements ConnectDao {

    List<Board> allBoard = new ArrayList<>();

    public ConnectMemDao(){
        Board onlyGame = new Board(100);
        allBoard.add(onlyGame);
    }

    @Override
    public Board getBoardbyId(Integer gameId) {

        Board toReturn = null;

        for(Board toCheck : allBoard){
            if(toCheck.getBoardId().equals(gameId)){
                toReturn = new Board(toCheck);
            }
        }
        return toReturn;
    }
}
