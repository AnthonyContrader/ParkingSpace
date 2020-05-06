import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { GatewaySharedModule } from 'app/shared';
import {
    FloorComponent,
    FloorDetailComponent,
    FloorUpdateComponent,
    FloorDeletePopupComponent,
    FloorDeleteDialogComponent,
    floorRoute,
    floorPopupRoute
} from './';

const ENTITY_STATES = [...floorRoute, ...floorPopupRoute];

@NgModule({
    imports: [GatewaySharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [FloorComponent, FloorDetailComponent, FloorUpdateComponent, FloorDeleteDialogComponent, FloorDeletePopupComponent],
    entryComponents: [FloorComponent, FloorUpdateComponent, FloorDeleteDialogComponent, FloorDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class GatewayFloorModule {}
