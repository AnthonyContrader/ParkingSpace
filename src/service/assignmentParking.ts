import { AssignmentParkingDTO } from './../dto/assignmentParking';
import { AbstractService } from './abstractservice';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
  })
export class AssignmentParkingService extends AbstractService<AssignmentParkingDTO>{
    constructor(http: HttpClient) {
        super(http);
        this.type='assignment';
    }
}