package com.tp.connectFour.persistence;

import com.tp.connectFour.models.Board;

public interface ConnectDao {

    Board getBoardbyId(Integer gameId);
}
