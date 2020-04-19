import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AdminRoutingModule } from './admin-routing.module';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UsersComponent } from './users/users.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';
<<<<<<< HEAD
import { CarsComponent } from "./cars/cars.component";
=======
import { PersonsComponent } from '../persons/persons.component';
>>>>>>> 89538b846dad6688b0418ea761406f103cd9c266

/**
 * Modulo dell'admin, qui vengono dichiarate le component che utilizza 
 * l'admin. Questo modulo importa AdminRoutingModule.
 * 
 * @author Vittorio Valent
 * 
 * @see AdminRoutingModule
 */
@NgModule({
<<<<<<< HEAD
  declarations: [AdminDashboardComponent, CarsComponent, UsersComponent, WorkInProgressComponent],
=======
  declarations: [AdminDashboardComponent, UsersComponent, PersonsComponent, WorkInProgressComponent],
>>>>>>> 89538b846dad6688b0418ea761406f103cd9c266
  imports: [
    CommonModule,
    AdminRoutingModule,
    FormsModule
  ]
})
export class AdminModule { }
