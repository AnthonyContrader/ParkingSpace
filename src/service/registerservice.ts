import { UserDTO } from './../dto/userdto';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { ManagedUserVM } from '../dto/ManagedUserVM';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
  })
export class SignUpService{

    constructor(protected http: HttpClient){
        this.http = http;
    }
    signup(dto: ManagedUserVM): Observable<ManagedUserVM>{
         console.log(dto.email, dto.login, dto.password, dto.firstName);
         
         return this.http.post<ManagedUserVM>('http://localhost:4040/api/register', dto);
    }
}