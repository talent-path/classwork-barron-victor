import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'test-control',
  templateUrl: './test-control.component.html',
  styleUrls: ['./test-control.component.css']
})
export class TestControlComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  defaultImageBool : boolean = true;
  imageSource : string = "./assets/60.png" ;
  onClick() : void {
    this.defaultImageBool = !this.defaultImageBool;
    if(this.defaultImageBool){
      this.imageSource = "./assets/60.png" ;
    }
    else{
      this.imageSource = "https://www.washingtonpost.com/wp-apps/imrs.php?src=https://arc-anglerfish-washpost-prod-washpost.s3.amazonaws.com/public/HB4AT3D3IMI6TMPTWIZ74WAR54.jpg&w=916"
    }
  }

}
