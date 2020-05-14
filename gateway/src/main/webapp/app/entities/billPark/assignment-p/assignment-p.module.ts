import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { GatewaySharedModule } from 'app/shared';
import {
    AssignmentPComponent,
    AssignmentPDetailComponent,
    AssignmentPUpdateComponent,
    AssignmentPDeletePopupComponent,
    AssignmentPDeleteDialogComponent,
    assignmentPRoute,
    assignmentPPopupRoute
} from './';

const ENTITY_STATES = [...assignmentPRoute, ...assignmentPPopupRoute];

@NgModule({
    imports: [GatewaySharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        AssignmentPComponent,
        AssignmentPDetailComponent,
        AssignmentPUpdateComponent,
        AssignmentPDeleteDialogComponent,
        AssignmentPDeletePopupComponent
    ],
    entryComponents: [AssignmentPComponent, AssignmentPUpdateComponent, AssignmentPDeleteDialogComponent, AssignmentPDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class GatewayAssignmentPModule {}
