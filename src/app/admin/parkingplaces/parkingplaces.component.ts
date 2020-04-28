import { FloorService } from 'src/service/floor.service';
import { FloorDTO } from 'src/dto/floordto';
import { Component, OnInit } from '@angular/core';
import { ParkingplaceDTO } from 'src/dto/parkingplacedto';
import { ParkingplaceService } from 'src/service/parkingplace.service';

@Component({
  selector: 'app-parkingplaces',
  templateUrl: './parkingplaces.component.html',
  styleUrls: ['./parkingplaces.component.css']
})
export class ParkingplacesComponent implements OnInit {

  parkingplaces : ParkingplaceDTO[];
  parkingplacetoinsert: ParkingplaceDTO = new ParkingplaceDTO();
  floorToInsert: FloorDTO;
  floor: FloorDTO;
  constructor(private service: ParkingplaceService, private serviceFloor: FloorService) { 
    //this.parkingplacetoinsert.floor = new FloorDTO();
  }

  ngOnInit() {
    //this.floorToInsert = new FloorDTO();
    this.floor=new FloorDTO();
    // this.getFloor();
    this.getParkingplaces();

  }
 /*  getFloor() {
     //(console.log("ciao: " + this.floorToInsert.toString);
     this.serviceFloor.read(this.floor.id).subscribe(floor => this.floor = floor);
  } */

  getParkingplaces(){
    this.service.getAll().subscribe(parkingplace => {this.parkingplaces = parkingplace; });
      /* this.parkingplaces.forEach(x => {
        this.floors.push(x.floor);
      }); */

    
  }

delete(parkingplace: ParkingplaceDTO){
  this.service.delete(parkingplace.id).subscribe(() => this.getParkingplaces());
}
update(parkingplace: ParkingplaceDTO){
  this.service.update(parkingplace).subscribe(() => this.getParkingplaces());
}

insert(parkingplace: ParkingplaceDTO){
  console.log(parkingplace);
  this.service.insert(parkingplace).subscribe(() => this.getParkingplaces());
}

clear(){
  this.parkingplacetoinsert = new ParkingplaceDTO();
}  

}
