import { UserDTO } from './userdto';
export class ManagedUserVM extends UserDTO{
    
    password: string

    constructor(password: string)
    {
        super();
        this.password = password;
    }
    
    toString(){
        return "{username: "+ this.firstName + " email: " + this.email +' '+ this.login +' '+ this.password +"}";
    }
}