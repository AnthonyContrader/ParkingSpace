import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IAssigmentParking } from 'app/shared/model/parkingspace/assigment-parking.model';

@Component({
    selector: 'jhi-assigment-parking-detail',
    templateUrl: './assigment-parking-detail.component.html'
})
export class AssigmentParkingDetailComponent implements OnInit {
    assigmentParking: IAssigmentParking;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ assigmentParking }) => {
            this.assigmentParking = assigmentParking;
        });
    }

    previousState() {
        window.history.back();
    }
}
