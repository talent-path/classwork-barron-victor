import { Component, OnInit } from '@angular/core';
import { Board, TicTacToeBoard } from 'src/app/gameFiles/board';
import { Position } from 'src/app/gameFiles/Position';

@Component({
  selector: 'ttt-board',
  templateUrl: './ttt-board.component.html',
  styleUrls: ['./ttt-board.component.css']
})
export class TttBoardComponent implements OnInit {
  board : Board = new TicTacToeBoard();
  selected : Position = null;
  constructor() { }

  ngOnInit(): void {
  }


  onSquareClicked(pos: Position) : void {
    if(this.board.pieceAt(pos) === null){
        if(this.board.isPlayerOneTurn){
           this.board = this.board.makeMove(pos);
        }
        else{
          this.board = this.board.makeMove(pos);
        }
        let eva : boolean = this.board.evaluate();
        if(eva != null){
            if(eva){
                alert("Player One Won!");
            }
            else{
                alert("Player Two Won!");
            }
        }
    }
  }

  
}

