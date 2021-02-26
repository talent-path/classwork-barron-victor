import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Player } from 'src/app/gameFiles/Player';
import { Position } from 'src/app/gameFiles/Position';

@Component({
  selector: 'ttt-square',
  templateUrl: './ttt-square.component.html',
  styleUrls: ['./ttt-square.component.css']
})
export class TttSquareComponent implements OnInit {
  @Output() squareClickedEvent : EventEmitter<Position> = new EventEmitter<Position>(); 
  @Input()square: Player = new Player(true);
  imgSrc : String = "./assets/";
  @Input()row : number = 0; 
  @Input()col : number = 0; 
  
  constructor() { }

  ngOnInit(): void {
    if(this.square == null){
      this.imgSrc = " "; 
    }
    else {
      if(this.square.isPlayerOne){
        this.imgSrc += "playerOne.png";
      }
      else{
        this.imgSrc += "playerTwo.png";
      }
    }
  }

  squareClicked() : void{
    this.squareClickedEvent.emit({row : this.row, col : this.col});
  }

}
