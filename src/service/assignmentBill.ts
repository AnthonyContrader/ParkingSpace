import { AssignmentParkingDTO } from './../dto/assignmentParking';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';

@Injectable({
    providedIn: 'root'
  })
export class AssignmentParkingService extends AbstractService<AssignmentParkingDTO>{
    type_entity: string;
    name_microservizio: string;
    constructor(http: HttpClient) {
        super(http);
        this.type_entity='assignment-parkings';
        this.name_microservizio = 'bill';
    }
}