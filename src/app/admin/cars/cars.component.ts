import { Component, OnInit } from '@angular/core';
import { CarService } from 'src/service/car.service';
import { CarDTO } from 'src/dto/cardto';

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.css']
})
export class CarsComponent implements OnInit {

  cars: CarDTO[];
  cartoinsert: CarDTO = new CarDTO();

  constructor(private service: CarService) { }

  ngOnInit() {
    this.getCars();
  }

  getCars() {
    this.service.getAll().subscribe(cars => this.cars = cars);
  }

  delete(car: CarDTO) {
    this.service.delete(car.id).subscribe(() => this.getCars());
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
}
