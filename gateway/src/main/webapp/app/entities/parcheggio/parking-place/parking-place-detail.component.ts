import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IParkingPlace } from 'app/shared/model/parcheggio/parking-place.model';

@Component({
    selector: 'jhi-parking-place-detail',
    templateUrl: './parking-place-detail.component.html'
})
export class ParkingPlaceDetailComponent implements OnInit {
    parkingPlace: IParkingPlace;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ parkingPlace }) => {
            this.parkingPlace = parkingPlace;
        });
    }

    previousState() {
        window.history.back();
    }
}
