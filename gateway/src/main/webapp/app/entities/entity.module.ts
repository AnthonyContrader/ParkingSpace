import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { GatewayCarModule as ParcheggioCarModule } from './parcheggio/car/car.module';
import { GatewayPersonModule as ParcheggioPersonModule } from './parcheggio/person/person.module';
import { GatewayParkingPlaceModule as ParcheggioParkingPlaceModule } from './parcheggio/parking-place/parking-place.module';
import { GatewayFloorModule as ParcheggioFloorModule } from './parcheggio/floor/floor.module';
import { GatewayAssigmentParkingModule as ParcheggioAssigmentParkingModule } from './parcheggio/assigment-parking/assigment-parking.module';
import { GatewayBillModule as BillbillBillModule } from './billbill/bill/bill.module';
import { GatewayAssignmentBModule as BillbillAssignmentBModule } from './billbill/assignment-b/assignment-b.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    // prettier-ignore
    imports: [
        ParcheggioCarModule,
        ParcheggioPersonModule,
        ParcheggioParkingPlaceModule,
        ParcheggioFloorModule,
        ParcheggioAssigmentParkingModule,
        BillbillBillModule,
        BillbillAssignmentBModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class GatewayEntityModule {}
