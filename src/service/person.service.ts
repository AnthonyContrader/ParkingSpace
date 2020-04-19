import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';
import {PersonDTO}    from 'src/dto/persondto';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
  })
export class PersonService extends AbstractService<PersonDTO>{
    constructor(http: HttpClient){
        super(http);
        this.type = 'person';
    }
}