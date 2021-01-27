package com.tp.hangman.services;

import com.tp.hangman.models.HangmanGame;
import com.tp.hangman.models.HangmanViewModel;
import com.tp.hangman.persistence.HangmanDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//handles the logic for the game
@Component
public class HangmanService {

    @Autowired
    HangmanDao dao;

    public HangmanViewModel getGameById(Integer gameId) {
        HangmanGame game = dao.getGameById( gameId );
        return convertModel( game );
    }


    public HangmanViewModel makeGuess(Integer gameId, String guess) {
        if( guess.length() != 1){
            //TODO: make and throw a custom exception here
            return null;
        }

        if( gameId == null ){
            //TODO: make and throw a custom exception here
            return null;
        }

        HangmanGame game = this.getGameById(gameId);

        //we'll assume here that the dao gives us back a null
        //if there's no matching game
        if( game == null) {
            return null;
        }

        game.getGuessedLetters().add(guess.charAt(0));

        return game;

    }


    private HangmanViewModel convertModel(HangmanGame game) {
        //TODO: generate the string with all the letters hidden that have not been guessed
        //and build the view model object (using the setters)

        throw new UnsupportedOperationException();
    }
}
