import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminLayoutComponent } from '../layout/admin-layout/admin-layout.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UsersComponent } from './users/users.component';
import { ParkingplacesComponent} from './parkingplaces/parkingplaces.component';
import { CarsComponent } from './cars/cars.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';
import { FloorComponent } from './floor/floor.component';
import { PersonsComponent } from '../persons/persons.component';
import { AssignmentParkingComponent } from './assignment-parking/assignment-parking.component';


/**
 * Modulo di routing dell'admin. Qui ci sono i percorsi che un admin può seguire:
 * appena fa il login viene caricato nel <router-outlet> di app-component il layout e nel 
 * <router-outlet> del layout (come percorsi "children") vengono visualizzati gli altri 
 * (qui sotto sono indentati).
 * 
 * @author Vittorio Valent
 * 
 * @see AdminLayoutComponent
 * 
 * @see layout
 */
const routes: Routes = [
  { path: 'admin-dashboard', component: AdminLayoutComponent, 
  children:[
            { path: '', component: AdminDashboardComponent},
            { path: 'cars', component: CarsComponent},
            { path: 'users', component: UsersComponent},
            { path: 'parkingplaces', component: ParkingplacesComponent},
            { path: 'work-in-progress', component: WorkInProgressComponent},
            { path: 'work-in-progress', component: WorkInProgressComponent},
            { path : 'floor' , component : FloorComponent},
            { path: 'persons', component: PersonsComponent},
            { path: 'assignments',component: AssignmentParkingComponent}
           ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { 
}