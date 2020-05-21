import { Injectable } from "@angular/core";
import { AbstractService } from './abstractservice';
import { FloorDTO } from 'src/dto/floordto';
import { HttpClient } from '@angular/common/http';

@Injectable ({
    providedIn : 'root'
})

export class FloorService extends AbstractService<FloorDTO>{
    constructor(http: HttpClient){
        super(http);
        this.type_entity= 'floors';
        this.name_microservizio = 'parkingspace';
    }
}
