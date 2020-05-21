//import { UserDTO } from './../dto/userdto';
import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { UserDTO } from 'src/dto/userdto';
import { HttpClient } from '@angular/common/http';
import { LoginDTO } from 'src/dto/logindto';
import { Observable } from 'rxjs';

/**
 * I service sono decorati da @Injectable. 
 * Qui trovate, oltre ai metodi ereditati dall'Abstract,
 *  il metodo per il login (in mirror con il backend).
 * 
 * @author Vittorio Valent
 * 
 * @see AbstractService
 */
@Injectable({
  providedIn: 'root'
})
export class UserService extends AbstractService<UserDTO>{


  constructor(http: HttpClient) {
    super(http);
    this.name = 'api';
    this.type_entity = 'users';
    this.name_microservizio = 'gateway';
    
  }

  login(loginDTO: LoginDTO): Observable<UserDTO> {     
    return this.http.post<any>('http://localhost:4040/' + this.name + '/authenticate', loginDTO);
  }

  auth(){
    console.log('Bearer '+localStorage.getItem("key"));
    const user = JSON.parse(localStorage.getItem("AUTOKEN")) as UserDTO;
    console.log("user: ",user);
    if(user){
      return 'Bearer '+ localStorage.getItem("key");
    }else {
      return '';
    }
  }
  userLogged(username: string) {
    return this.http.get('http://localhost:4040/api/users/' + username, {headers: {Authorization: this.auth()}});
  }

}
