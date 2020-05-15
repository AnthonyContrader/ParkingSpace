import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { GatewaySharedModule } from 'app/shared';
import {
    AssigmentParkingComponent,
    AssigmentParkingDetailComponent,
    AssigmentParkingUpdateComponent,
    AssigmentParkingDeletePopupComponent,
    AssigmentParkingDeleteDialogComponent,
    assigmentParkingRoute,
    assigmentParkingPopupRoute
} from './';

const ENTITY_STATES = [...assigmentParkingRoute, ...assigmentParkingPopupRoute];

@NgModule({
    imports: [GatewaySharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        AssigmentParkingComponent,
        AssigmentParkingDetailComponent,
        AssigmentParkingUpdateComponent,
        AssigmentParkingDeleteDialogComponent,
        AssigmentParkingDeletePopupComponent
    ],
    entryComponents: [
        AssigmentParkingComponent,
        AssigmentParkingUpdateComponent,
        AssigmentParkingDeleteDialogComponent,
        AssigmentParkingDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class GatewayAssigmentParkingModule {}
