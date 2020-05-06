import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { of } from 'rxjs';
import { map } from 'rxjs/operators';
import { ParkingPlace } from 'app/shared/model/belino1/parking-place.model';
import { ParkingPlaceService } from './parking-place.service';
import { ParkingPlaceComponent } from './parking-place.component';
import { ParkingPlaceDetailComponent } from './parking-place-detail.component';
import { ParkingPlaceUpdateComponent } from './parking-place-update.component';
import { ParkingPlaceDeletePopupComponent } from './parking-place-delete-dialog.component';
import { IParkingPlace } from 'app/shared/model/belino1/parking-place.model';

@Injectable({ providedIn: 'root' })
export class ParkingPlaceResolve implements Resolve<IParkingPlace> {
    constructor(private service: ParkingPlaceService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(map((parkingPlace: HttpResponse<ParkingPlace>) => parkingPlace.body));
        }
        return of(new ParkingPlace());
    }
}

export const parkingPlaceRoute: Routes = [
    {
        path: 'parking-place',
        component: ParkingPlaceComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ParkingPlaces'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'parking-place/:id/view',
        component: ParkingPlaceDetailComponent,
        resolve: {
            parkingPlace: ParkingPlaceResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ParkingPlaces'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'parking-place/new',
        component: ParkingPlaceUpdateComponent,
        resolve: {
            parkingPlace: ParkingPlaceResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ParkingPlaces'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'parking-place/:id/edit',
        component: ParkingPlaceUpdateComponent,
        resolve: {
            parkingPlace: ParkingPlaceResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ParkingPlaces'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const parkingPlacePopupRoute: Routes = [
    {
        path: 'parking-place/:id/delete',
        component: ParkingPlaceDeletePopupComponent,
        resolve: {
            parkingPlace: ParkingPlaceResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ParkingPlaces'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
