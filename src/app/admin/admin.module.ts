import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AdminRoutingModule } from './admin-routing.module';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UsersComponent } from './users/users.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';
import { FloorComponent } from './floor/floor.component';
import { CarsComponent } from "./cars/cars.component";
import { PersonsComponent } from '../persons/persons.component';

/**
 * Modulo dell'admin, qui vengono dichiarate le component che utilizza 
 * l'admin. Questo modulo importa AdminRoutingModule.
 * 
 * @author Vittorio Valent
 * 
 * @see AdminRoutingModule
 */
@NgModule({
  declarations: [AdminDashboardComponent, UsersComponent , FloorComponent, CarsComponent,PersonsComponent, WorkInProgressComponent],
  
  imports: [
    CommonModule,
    AdminRoutingModule,
    FormsModule
  ]
})
export class AdminModule { }
