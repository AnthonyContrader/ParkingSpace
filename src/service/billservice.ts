import { HttpClient } from '@angular/common/http';
import { BillDTO } from './../dto/billdto';
import { AbstractService } from "./abstractservice"
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
  })
export class BillService extends AbstractService<BillDTO>{
    constructor(protected http: HttpClient){
        super(http);
        this.type_entity = 'bills';
        this.name_microservizio = 'bill';
    }
}