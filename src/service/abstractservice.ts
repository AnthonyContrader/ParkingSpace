import { Service } from './service';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

/**
 * Service astratto, implementa tutti i metodi CRUD inviando request al server di SpringBoot. 
 * @param port il port del backend
 * @param type la mappatura del controller di ciascuna entità.
 * 
 * @see Service
 * 
 * @author Vittorio Valent
 */
export abstract class AbstractService<DTO> implements Service<DTO> {

    name: string = 'api';
    type_entity: string;
    name_microservizio: string;
    app_protocol: string = 'http';
    server_ip: string = 'localhost';
    port: string = '4040';

    constructor(protected http: HttpClient) {
    }
    //return token string
    auth(){
        if(localStorage.getItem("key")!=''){
          return 'Bearer '+ localStorage.getItem("key");
        }else {
          return '';
        }
    }
    //return header with Bearer token in json.
    getAuth(){
        return {headers: {Authorization: this.auth()}};
    }

    getAll(): Observable<DTO[]> {
        if(this.name_microservizio == 'gateway')
           return this.http.get<DTO[]>(this.app_protocol+ '://' + this.server_ip + ':' + this.port 
           + '/' + this.name + '/' + this.type_entity, this.getAuth());
        else{
            return this.http.get<DTO[]>(this.app_protocol + '://' +this.server_ip + ':' + this.port 
            + '/' + this.name_microservizio + '/'  + this.name + '/' + this.type_entity, this.getAuth());
        }
    }
    read(id: number): Observable<DTO> {
        if(this.name_microservizio == 'gateway'){
            return this.http.get<DTO>('http://localhost:4040' + '/' + this.type_entity + id);
        }else{
            return this.http.get<DTO>('http://localhost:4040' + '/' + this.name_microservizio + '/' 
            + this.name + '/'  + this.type_entity + id);
        }
    }

    delete(id: number): Observable<any> {
        return this.http.delete('http://localhost:' + this.port + '/' + this.name_microservizio + '/' + this.name+ '/'+this.type_entity + '/' + id, this.getAuth());
    }

    insert(dto: DTO): Observable<any> {
        return this.http.post('http://localhost:' + this.port + '/' +  this.name_microservizio + '/' 
        + this.name + '/' + this.type_entity, dto , this.getAuth());
    }

    update(dto: DTO): Observable<DTO> {
        return this.http.put<DTO>('http://localhost:' + this.port + '/' + this.name_microservizio + '/' 
        + this.name + '/' + this.type_entity , dto, this.getAuth());
    }

}