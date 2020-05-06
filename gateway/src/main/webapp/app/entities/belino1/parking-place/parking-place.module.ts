import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { GatewaySharedModule } from 'app/shared';
import {
    ParkingPlaceComponent,
    ParkingPlaceDetailComponent,
    ParkingPlaceUpdateComponent,
    ParkingPlaceDeletePopupComponent,
    ParkingPlaceDeleteDialogComponent,
    parkingPlaceRoute,
    parkingPlacePopupRoute
} from './';

const ENTITY_STATES = [...parkingPlaceRoute, ...parkingPlacePopupRoute];

@NgModule({
    imports: [GatewaySharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        ParkingPlaceComponent,
        ParkingPlaceDetailComponent,
        ParkingPlaceUpdateComponent,
        ParkingPlaceDeleteDialogComponent,
        ParkingPlaceDeletePopupComponent
    ],
    entryComponents: [
        ParkingPlaceComponent,
        ParkingPlaceUpdateComponent,
        ParkingPlaceDeleteDialogComponent,
        ParkingPlaceDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class GatewayParkingPlaceModule {}
