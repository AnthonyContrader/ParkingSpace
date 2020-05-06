import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { GatewayCarModule as Belino1CarModule } from './belino1/car/car.module';
import { GatewayPersonModule as Belino1PersonModule } from './belino1/person/person.module';
import { GatewayParkingPlaceModule as Belino1ParkingPlaceModule } from './belino1/parking-place/parking-place.module';
import { GatewayFloorModule as Belino1FloorModule } from './belino1/floor/floor.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    // prettier-ignore
    imports: [
        Belino1CarModule,
        Belino1PersonModule,
        Belino1ParkingPlaceModule,
        Belino1FloorModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class GatewayEntityModule {}
