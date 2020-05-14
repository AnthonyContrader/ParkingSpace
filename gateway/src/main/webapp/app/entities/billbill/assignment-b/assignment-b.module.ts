import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { GatewaySharedModule } from 'app/shared';
import {
    AssignmentBComponent,
    AssignmentBDetailComponent,
    AssignmentBUpdateComponent,
    AssignmentBDeletePopupComponent,
    AssignmentBDeleteDialogComponent,
    assignmentBRoute,
    assignmentBPopupRoute
} from './';

const ENTITY_STATES = [...assignmentBRoute, ...assignmentBPopupRoute];

@NgModule({
    imports: [GatewaySharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        AssignmentBComponent,
        AssignmentBDetailComponent,
        AssignmentBUpdateComponent,
        AssignmentBDeleteDialogComponent,
        AssignmentBDeletePopupComponent
    ],
    entryComponents: [AssignmentBComponent, AssignmentBUpdateComponent, AssignmentBDeleteDialogComponent, AssignmentBDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class GatewayAssignmentBModule {}
