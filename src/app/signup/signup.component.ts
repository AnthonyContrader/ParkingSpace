import { SignUpService } from './../../service/registerservice';
import { ManagedUserVM } from '../../dto/ManagedUserVM';
import { NgForm } from '@angular/forms';
import { UserDTO } from './../../dto/userdto';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  //object to manage User UI
  managedUserVm: ManagedUserVM;

  constructor(private service: SignUpService) { }

  ngOnInit() {

  }

  register(f:NgForm){
    this.managedUserVm = new ManagedUserVM(f.value.password);
    this.managedUserVm.firstName = f.value.firstName;
    this.managedUserVm.email = f.value.email;
    this.managedUserVm.login = f.value.login;
    
    this.service.signup(this.managedUserVm).subscribe(()=>this.managedUserVm = this.managedUserVm);

  }
  
}
