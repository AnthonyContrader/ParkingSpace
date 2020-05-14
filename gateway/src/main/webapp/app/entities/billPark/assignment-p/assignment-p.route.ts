import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { of } from 'rxjs';
import { map } from 'rxjs/operators';
import { AssignmentP } from 'app/shared/model/billPark/assignment-p.model';
import { AssignmentPService } from './assignment-p.service';
import { AssignmentPComponent } from './assignment-p.component';
import { AssignmentPDetailComponent } from './assignment-p-detail.component';
import { AssignmentPUpdateComponent } from './assignment-p-update.component';
import { AssignmentPDeletePopupComponent } from './assignment-p-delete-dialog.component';
import { IAssignmentP } from 'app/shared/model/billPark/assignment-p.model';

@Injectable({ providedIn: 'root' })
export class AssignmentPResolve implements Resolve<IAssignmentP> {
    constructor(private service: AssignmentPService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(map((assignmentP: HttpResponse<AssignmentP>) => assignmentP.body));
        }
        return of(new AssignmentP());
    }
}

export const assignmentPRoute: Routes = [
    {
        path: 'assignment-p',
        component: AssignmentPComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            defaultSort: 'id,asc',
            pageTitle: 'AssignmentPS'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'assignment-p/:id/view',
        component: AssignmentPDetailComponent,
        resolve: {
            assignmentP: AssignmentPResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'AssignmentPS'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'assignment-p/new',
        component: AssignmentPUpdateComponent,
        resolve: {
            assignmentP: AssignmentPResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'AssignmentPS'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'assignment-p/:id/edit',
        component: AssignmentPUpdateComponent,
        resolve: {
            assignmentP: AssignmentPResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'AssignmentPS'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const assignmentPPopupRoute: Routes = [
    {
        path: 'assignment-p/:id/delete',
        component: AssignmentPDeletePopupComponent,
        resolve: {
            assignmentP: AssignmentPResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'AssignmentPS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
