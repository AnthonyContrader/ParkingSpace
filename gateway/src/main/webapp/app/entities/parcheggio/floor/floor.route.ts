import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { of } from 'rxjs';
import { map } from 'rxjs/operators';
import { Floor } from 'app/shared/model/parcheggio/floor.model';
import { FloorService } from './floor.service';
import { FloorComponent } from './floor.component';
import { FloorDetailComponent } from './floor-detail.component';
import { FloorUpdateComponent } from './floor-update.component';
import { FloorDeletePopupComponent } from './floor-delete-dialog.component';
import { IFloor } from 'app/shared/model/parcheggio/floor.model';

@Injectable({ providedIn: 'root' })
export class FloorResolve implements Resolve<IFloor> {
    constructor(private service: FloorService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(map((floor: HttpResponse<Floor>) => floor.body));
        }
        return of(new Floor());
    }
}

export const floorRoute: Routes = [
    {
        path: 'floor',
        component: FloorComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            defaultSort: 'id,asc',
            pageTitle: 'Floors'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'floor/:id/view',
        component: FloorDetailComponent,
        resolve: {
            floor: FloorResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Floors'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'floor/new',
        component: FloorUpdateComponent,
        resolve: {
            floor: FloorResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Floors'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'floor/:id/edit',
        component: FloorUpdateComponent,
        resolve: {
            floor: FloorResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Floors'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const floorPopupRoute: Routes = [
    {
        path: 'floor/:id/delete',
        component: FloorDeletePopupComponent,
        resolve: {
            floor: FloorResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Floors'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
