import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { of } from 'rxjs';
import { map } from 'rxjs/operators';
import { AssignmentB } from 'app/shared/model/billbill/assignment-b.model';
import { AssignmentBService } from './assignment-b.service';
import { AssignmentBComponent } from './assignment-b.component';
import { AssignmentBDetailComponent } from './assignment-b-detail.component';
import { AssignmentBUpdateComponent } from './assignment-b-update.component';
import { AssignmentBDeletePopupComponent } from './assignment-b-delete-dialog.component';
import { IAssignmentB } from 'app/shared/model/billbill/assignment-b.model';

@Injectable({ providedIn: 'root' })
export class AssignmentBResolve implements Resolve<IAssignmentB> {
    constructor(private service: AssignmentBService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(map((assignmentB: HttpResponse<AssignmentB>) => assignmentB.body));
        }
        return of(new AssignmentB());
    }
}

export const assignmentBRoute: Routes = [
    {
        path: 'assignment-b',
        component: AssignmentBComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            defaultSort: 'id,asc',
            pageTitle: 'AssignmentBS'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'assignment-b/:id/view',
        component: AssignmentBDetailComponent,
        resolve: {
            assignmentB: AssignmentBResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'AssignmentBS'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'assignment-b/new',
        component: AssignmentBUpdateComponent,
        resolve: {
            assignmentB: AssignmentBResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'AssignmentBS'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'assignment-b/:id/edit',
        component: AssignmentBUpdateComponent,
        resolve: {
            assignmentB: AssignmentBResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'AssignmentBS'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const assignmentBPopupRoute: Routes = [
    {
        path: 'assignment-b/:id/delete',
        component: AssignmentBDeletePopupComponent,
        resolve: {
            assignmentB: AssignmentBResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'AssignmentBS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
