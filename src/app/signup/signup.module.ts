import { SignupComponent } from './signup.component';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { LoginRoutingModule } from '../login/login-routing.module';
import { CommonModule } from '@angular/common';




@NgModule({
    declarations: [SignupComponent],
  
    imports: [
      CommonModule,
      LoginRoutingModule,
      FormsModule
    ]
    
  })

export class SignUpModule{

}