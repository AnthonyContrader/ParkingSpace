import { Injectable } from '@angular/core';
import {ParkingplaceDTO  } from 'src/dto/parkingplacedto';
import {HttpClient} from '@angular/common/http';
import { AbstractService } from './abstractservice';

@Injectable({
  providedIn: 'root'
})
export class ParkingplaceService extends AbstractService<ParkingplaceDTO> {

  constructor(http: HttpClient) { 
    super(http);
    this.type_entity= 'parking-places';
    this.name_microservizio = 'parkingspace';
  }
}
