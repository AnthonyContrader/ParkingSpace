import { CarDTO } from 'src/dto/cardto';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-cars-list-by-model',
  templateUrl: './cars-list-by-model.component.html',
  styleUrls: ['./cars-list-by-model.component.css']
})
export class CarsListByModelComponent implements OnInit {

  @Input() models=[];
  
  constructor() { }

  ngOnInit() {
    console.log(this.models.length);
    console.log("sono nel init di CarlistComponent");
  }

}
