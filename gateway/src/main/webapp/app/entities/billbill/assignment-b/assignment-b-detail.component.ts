import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IAssignmentB } from 'app/shared/model/billbill/assignment-b.model';

@Component({
    selector: 'jhi-assignment-b-detail',
    templateUrl: './assignment-b-detail.component.html'
})
export class AssignmentBDetailComponent implements OnInit {
    assignmentB: IAssignmentB;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ assignmentB }) => {
            this.assignmentB = assignmentB;
        });
    }

    previousState() {
        window.history.back();
    }
}
