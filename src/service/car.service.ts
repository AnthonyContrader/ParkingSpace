import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { CarDTO } from 'src/dto/cardto';
import { HttpClient } from '@angular/common/http';


/**
 * I service sono decorati da @Injectable. 
 * Qui trovate, oltre ai metodi ereditati dall'Abstract,
 *  il metodo per il login (in mirror con il backend).
 * 
 *
 */
@Injectable({
  providedIn: 'root'
})
export class CarService extends AbstractService<CarDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'car';
  }

}
