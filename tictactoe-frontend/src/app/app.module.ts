import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { TttBoardComponent } from './ttt-board/ttt-board.component';
import { TttSquareComponent } from './ttt-square/ttt-square.component';

@NgModule({
  declarations: [
    AppComponent,
    TttBoardComponent,
    TttSquareComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
