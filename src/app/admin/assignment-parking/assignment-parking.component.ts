import { ParkingplaceService } from './../../../service/parkingplace.service';
import { CarService } from './../../../service/car.service';
import { ParkingplaceDTO } from './../../../dto/parkingplacedto';
import { AssignmentParkingService } from './../../../service/assignmentParking';
import { AssignmentParkingDTO } from './../../../dto/assignmentParking';
import { Component, OnInit } from '@angular/core';
import { CarDTO } from 'src/dto/cardto';

@Component({
  selector: 'app-assignment-parking',
  templateUrl: './assignment-parking.component.html',
  styleUrls: ['./assignment-parking.component.css']
})
export class AssignmentParkingComponent implements OnInit {
  //dichiariamo un array di oggetti dto + un singolo oggetto dto come reference per insert
  assignments: AssignmentParkingDTO[];
  assignmentToInsert: AssignmentParkingDTO = new AssignmentParkingDTO();
  cars: CarDTO[];
  parkingplaces: ParkingplaceDTO[];
  constructor(private service: AssignmentParkingService, 
    private carService: CarService, private parkingService: ParkingplaceService) { }

  ngOnInit() {
  
    this.getAssignments();
  }

  getAssignments(){
      this.setCarPark();
      this.service.getAll().subscribe(assignments => this.assignments = assignments);
  }
  delete(assignment: AssignmentParkingDTO){
      this.service.delete(assignment.id).subscribe(()=>this.getAssignments())
  }
  update(assignment: AssignmentParkingDTO){
      this.service.update(assignment).subscribe(()=>this.getAssignments());
  }
  insert(assignment: AssignmentParkingDTO){
      this.service.insert(assignment).subscribe(()=>this.getAssignments());
  }
  clear(){
    this.assignmentToInsert = new AssignmentParkingDTO();
  }
  setCarPark(){
      this.carService.getAll().subscribe(cars => this.cars = cars);
      this.parkingService.getAll().subscribe(parkingplaces=> this.parkingplaces = parkingplaces);
  }

}
