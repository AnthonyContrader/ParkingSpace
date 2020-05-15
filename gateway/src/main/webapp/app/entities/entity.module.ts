import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { GatewayCarModule as ParkingspaceCarModule } from './parkingspace/car/car.module';
import { GatewayPersonModule as ParkingspacePersonModule } from './parkingspace/person/person.module';
import { GatewayParkingPlaceModule as ParkingspaceParkingPlaceModule } from './parkingspace/parking-place/parking-place.module';
import { GatewayFloorModule as ParkingspaceFloorModule } from './parkingspace/floor/floor.module';
import { GatewayAssigmentParkingModule as ParkingspaceAssigmentParkingModule } from './parkingspace/assigment-parking/assigment-parking.module';
import { GatewayBillModule as BillBillModule } from './bill/bill/bill.module';
import { GatewayAssignmentParkingModule as BillAssignmentParkingModule } from './bill/assignment-parking/assignment-parking.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    // prettier-ignore
    imports: [
        ParkingspaceCarModule,
        ParkingspacePersonModule,
        ParkingspaceParkingPlaceModule,
        ParkingspaceFloorModule,
        ParkingspaceAssigmentParkingModule,
        BillBillModule,
        BillAssignmentParkingModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class GatewayEntityModule {}
