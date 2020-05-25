import { ParkingplaceDTO } from 'src/dto/parkingplacedto';
import { CarDTO } from 'src/dto/cardto';
import { Time } from '@angular/common';
/**
 * Classe DTO di AssignmentParking. DEVE essere uguale (stesso nome classe, stessi attributi e stessi nomi) a
 * quello nel backend. 
 * 
 */
export class AssignmentParkingDTO{
    id: number;
    car: number;
    parkingplace: number;
    entryDateTime: Date; 

    constructor(){
        this.entryDateTime = new Date();
    }
}