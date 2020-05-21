

import { Component, OnInit, Input, Output } from '@angular/core';
import { CarService } from 'src/service/car.service';
import { CarDTO } from 'src/dto/cardto';
import { EventEmitter } from 'protractor';


@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.css']
})
export class CarsComponent implements OnInit {

  cars: CarDTO[];
  cars1: CarDTO[];
  cartoinsert: CarDTO = new CarDTO();
  models: CarDTO[]=[];
  model: String;
  carToCheck: CarDTO = new CarDTO();

  constructor(private service: CarService) { }

  ngOnInit() {
    this.getCars();
  }

  getCars() {
    this.service.getAll().subscribe(cars => this.cars = cars);
  }

  delete(id: number) {
    this.service.delete(id).subscribe(() => this.getCars());
  }

  update(car: CarDTO) {
    this.service.update(car).subscribe(() => this.getCars());
  }

  insert(car: CarDTO) {
    this.service.insert(car).subscribe(() => this.getCars());
  }

  clear(){
    this.cartoinsert = new CarDTO();
  }
  //@Output() object = new EventEmitter(); problemi di ??loader??
  getAllByModel(model:String){
    console.log("ciao ciao ciaos");
    this.model=model;
    console.log(this.model);
    for(let car of this.cars){
       if(car.model===model){ 
        this.models.push(car);

       }
    console.log(this.models.length);
    //this.object.emit('this.models');
    }
    
  } 
  
}
