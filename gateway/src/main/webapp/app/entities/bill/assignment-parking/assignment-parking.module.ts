import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { GatewaySharedModule } from 'app/shared';
import {
    AssignmentParkingComponent,
    AssignmentParkingDetailComponent,
    AssignmentParkingUpdateComponent,
    AssignmentParkingDeletePopupComponent,
    AssignmentParkingDeleteDialogComponent,
    assignmentParkingRoute,
    assignmentParkingPopupRoute
} from './';

const ENTITY_STATES = [...assignmentParkingRoute, ...assignmentParkingPopupRoute];

@NgModule({
    imports: [GatewaySharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        AssignmentParkingComponent,
        AssignmentParkingDetailComponent,
        AssignmentParkingUpdateComponent,
        AssignmentParkingDeleteDialogComponent,
        AssignmentParkingDeletePopupComponent
    ],
    entryComponents: [
        AssignmentParkingComponent,
        AssignmentParkingUpdateComponent,
        AssignmentParkingDeleteDialogComponent,
        AssignmentParkingDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class GatewayAssignmentParkingModule {}
