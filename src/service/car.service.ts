import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { CarDTO } from 'src/dto/cardto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


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
    this.type_entity = 'cars';
    this.name_microservizio = 'parkingspace';
  }
  
  /* deleteCar(license: string): Observable<any> {
    return this.http.delete('http://localhost:' + this.port + '/' + this.type_entity + '/delete?id=' + license);
  }
  readCar(license: string): Observable<CarDTO> {
    return this.http.get<CarDTO>('http://localhost:' + this.port + '/' + this.type_entity + '/read?id=' + license);
  }
  insertCar(dto:CarDTO): Observable<any> {
    return this.http.post('http://localhost:' + this.port + '/' + this.type_entity + '/insert', dto);
}

  updateCar(dto: CarDTO): Observable<CarDTO> {
    return this.http.put<CarDTO>('http://localhost:' + this.port + '/' + this.type_entity + '/update', dto);

  } */



}
