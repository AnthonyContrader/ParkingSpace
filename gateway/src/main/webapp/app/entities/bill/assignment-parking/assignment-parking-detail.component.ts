import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IAssignmentParking } from 'app/shared/model/bill/assignment-parking.model';

@Component({
    selector: 'jhi-assignment-parking-detail',
    templateUrl: './assignment-parking-detail.component.html'
})
export class AssignmentParkingDetailComponent implements OnInit {
    assignmentParking: IAssignmentParking;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ assignmentParking }) => {
            this.assignmentParking = assignmentParking;
        });
    }

    previousState() {
        window.history.back();
    }
}
