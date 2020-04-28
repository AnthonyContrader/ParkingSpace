import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AdminRoutingModule } from './admin-routing.module';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UsersComponent } from './users/users.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';
import { ParkingplacesComponent } from './parkingplaces/parkingplaces.component';
import { FloorComponent } from './floor/floor.component';
import { CarsComponent } from "./cars/cars.component";
import { PersonsComponent } from '../persons/persons.component';
import { AssignmentParkingComponent } from './assignment-parking/assignment-parking.component';
import { CarsListByModelComponent } from './cars/cars-list-by-model/cars-list-by-model.component';
/**
 * Modulo dell'admin, qui vengono dichiarate le component che utilizza 
 * l'admin. Questo modulo importa AdminRoutingModule.
 * 
 * @author Vittorio Valent
 * 
 * @see AdminRoutingModule
 */
@NgModule({
  
  declarations: [AdminDashboardComponent, UsersComponent , FloorComponent, CarsComponent,PersonsComponent, WorkInProgressComponent,ParkingplacesComponent, AssignmentParkingComponent, CarsListByModelComponent],
  
  imports: [
    CommonModule,
    AdminRoutingModule,
    FormsModule
  ]
})
export class AdminModule { }
