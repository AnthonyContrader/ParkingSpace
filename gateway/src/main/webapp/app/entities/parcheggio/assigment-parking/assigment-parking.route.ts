import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { of } from 'rxjs';
import { map } from 'rxjs/operators';
import { AssigmentParking } from 'app/shared/model/parcheggio/assigment-parking.model';
import { AssigmentParkingService } from './assigment-parking.service';
import { AssigmentParkingComponent } from './assigment-parking.component';
import { AssigmentParkingDetailComponent } from './assigment-parking-detail.component';
import { AssigmentParkingUpdateComponent } from './assigment-parking-update.component';
import { AssigmentParkingDeletePopupComponent } from './assigment-parking-delete-dialog.component';
import { IAssigmentParking } from 'app/shared/model/parcheggio/assigment-parking.model';

@Injectable({ providedIn: 'root' })
export class AssigmentParkingResolve implements Resolve<IAssigmentParking> {
    constructor(private service: AssigmentParkingService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(map((assigmentParking: HttpResponse<AssigmentParking>) => assigmentParking.body));
        }
        return of(new AssigmentParking());
    }
}

export const assigmentParkingRoute: Routes = [
    {
        path: 'assigment-parking',
        component: AssigmentParkingComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            defaultSort: 'id,asc',
            pageTitle: 'AssigmentParkings'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'assigment-parking/:id/view',
        component: AssigmentParkingDetailComponent,
        resolve: {
            assigmentParking: AssigmentParkingResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'AssigmentParkings'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'assigment-parking/new',
        component: AssigmentParkingUpdateComponent,
        resolve: {
            assigmentParking: AssigmentParkingResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'AssigmentParkings'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'assigment-parking/:id/edit',
        component: AssigmentParkingUpdateComponent,
        resolve: {
            assigmentParking: AssigmentParkingResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'AssigmentParkings'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const assigmentParkingPopupRoute: Routes = [
    {
        path: 'assigment-parking/:id/delete',
        component: AssigmentParkingDeletePopupComponent,
        resolve: {
            assigmentParking: AssigmentParkingResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'AssigmentParkings'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
