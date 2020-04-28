import { CarDTO } from './../../dto/cardto';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-search-by-model',
  templateUrl: './search-by-model.component.html',
  styleUrls: ['./search-by-model.component.css']
})
export class SearchByModelComponent implements OnInit {

  @Input()models: CarDTO[]=[];
  question=[];
  constructor() { }

  ngOnInit() {
    this.question = this.models;
  }

}
