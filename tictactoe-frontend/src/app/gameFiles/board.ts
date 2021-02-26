import { Player } from "./Player";
import { Position } from "./Position";

export interface Board{

    allSquares : Player[][];

    isPlayerOneTurn : boolean;
    makeMove : (this: Board, toMake : Position) => Board;
    pieceAt : ( loc: Position ) => Player;
}

export class TicTacToeBoard implements Board{
    allSquares : Player[][];
    isPlayerOneTurn : boolean = true;

    pieceAt( loc : Position ) : Player{
        return this.allSquares[loc.row][loc.col];
    }

    constructor( copyFrom?: TicTacToeBoard ){
        if( copyFrom ){
            this.buildFrom( copyFrom );
        }
        else{
            this.allSquares = [];
            for( let row = 0; row < 3; row++ ){
                this.allSquares[row] = [];
                for( let col = 0; col < 3; col++ ){
                    this.allSquares[row][col] = new Player();
                }
            }
        }
    }
    buildFrom( toCopy : Board ) {
        this.allSquares = [];
        for( let i = 0; i < toCopy.allSquares.length; i++ ){
            this.allSquares.push( [...toCopy.allSquares[i]] );
        }
    }

    makeMove: ( toMake : Position) => Board = toMake => {
        let nextBoard : TicTacToeBoard = new TicTacToeBoard(this);
        let who : Player = new Player(this.isPlayerOneTurn);
        nextBoard.allSquares[toMake.row][toMake.col] = who;
        nextBoard.isPlayerOneTurn = !this.isPlayerOneTurn;
        return nextBoard;
    }

    evaluate(): boolean {

        if(this.allSquares[0][0].isPlayerOne === this.allSquares[0][1].isPlayerOne === this.allSquares[0][2].isPlayerOne) return this.allSquares[0][0].isPlayerOne;     //top row

        else if(this.allSquares[0][0].isPlayerOne === this.allSquares[1][0].isPlayerOne === this.allSquares[2][0].isPlayerOne) return this.allSquares[0][0].isPlayerOne; //left column

        //right column
        else if(this.allSquares[0][2].isPlayerOne === this.allSquares[1][2].isPlayerOne === this.allSquares[2][2].isPlayerOne) return this.allSquares[0][2].isPlayerOne;

        //Bottom row
        else if(this.allSquares[2][0].isPlayerOne === this.allSquares[2][1].isPlayerOne === this.allSquares[2][2].isPlayerOne) return this.allSquares[2][0].isPlayerOne;

        //Middle row
        else if(this.allSquares[1][0].isPlayerOne === this.allSquares[1][1].isPlayerOne === this.allSquares[1][2].isPlayerOne) return this.allSquares[1][0].isPlayerOne;

        //Middle column
        else if(this.allSquares[0][1].isPlayerOne === this.allSquares[1][1].isPlayerOne === this.allSquares[2][1].isPlayerOne) return this.allSquares[0][1].isPlayerOne;

        //left to bottom right diagonal
        else if(this.allSquares[0][0].isPlayerOne === this.allSquares[1][1].isPlayerOne === this.allSquares[2][2].isPlayerOne) return this.allSquares[0][0].isPlayerOne;

        //right to left diagonal
        else if(this.allSquares[0][2].isPlayerOne === this.allSquares[1][1].isPlayerOne === this.allSquares[2][0].isPlayerOne) return this.allSquares[0][2].isPlayerOne;


    }

}