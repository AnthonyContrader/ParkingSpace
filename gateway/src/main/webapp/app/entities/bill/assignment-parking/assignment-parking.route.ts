import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { of } from 'rxjs';
import { map } from 'rxjs/operators';
import { AssignmentParking } from 'app/shared/model/bill/assignment-parking.model';
import { AssignmentParkingService } from './assignment-parking.service';
import { AssignmentParkingComponent } from './assignment-parking.component';
import { AssignmentParkingDetailComponent } from './assignment-parking-detail.component';
import { AssignmentParkingUpdateComponent } from './assignment-parking-update.component';
import { AssignmentParkingDeletePopupComponent } from './assignment-parking-delete-dialog.component';
import { IAssignmentParking } from 'app/shared/model/bill/assignment-parking.model';

@Injectable({ providedIn: 'root' })
export class AssignmentParkingResolve implements Resolve<IAssignmentParking> {
    constructor(private service: AssignmentParkingService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(map((assignmentParking: HttpResponse<AssignmentParking>) => assignmentParking.body));
        }
        return of(new AssignmentParking());
    }
}

export const assignmentParkingRoute: Routes = [
    {
        path: 'assignment-parking',
        component: AssignmentParkingComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'AssignmentParkings'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'assignment-parking/:id/view',
        component: AssignmentParkingDetailComponent,
        resolve: {
            assignmentParking: AssignmentParkingResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'AssignmentParkings'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'assignment-parking/new',
        component: AssignmentParkingUpdateComponent,
        resolve: {
            assignmentParking: AssignmentParkingResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'AssignmentParkings'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'assignment-parking/:id/edit',
        component: AssignmentParkingUpdateComponent,
        resolve: {
            assignmentParking: AssignmentParkingResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'AssignmentParkings'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const assignmentParkingPopupRoute: Routes = [
    {
        path: 'assignment-parking/:id/delete',
        component: AssignmentParkingDeletePopupComponent,
        resolve: {
            assignmentParking: AssignmentParkingResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'AssignmentParkings'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
