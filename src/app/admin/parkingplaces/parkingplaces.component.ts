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

  constructor(private service: ParkingplaceService) { }

  ngOnInit() {
    this.getParkingplaces();
  }

  getParkingplaces(){
    this.service.getAll().subscribe(parkingplaces => this.parkingplaces = parkingplaces);
  }

delete(parkingplace: ParkingplaceDTO){
  this.service.delete(parkingplace.id).subscribe(() => this.getParkingplaces());
}
update(parkingplace: ParkingplaceDTO){
  this.service.update(parkingplace).subscribe(() => this.getParkingplaces());
}
insert(parkingplace: ParkingplaceDTO){
  this.service.insert(parkingplace).subscribe(() => this.getParkingplaces());
}
clear(){
  this.parkingplacetoinsert = new ParkingplaceDTO();
}  

  }
