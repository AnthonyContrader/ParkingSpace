import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IAssignmentP } from 'app/shared/model/billPark/assignment-p.model';

@Component({
    selector: 'jhi-assignment-p-detail',
    templateUrl: './assignment-p-detail.component.html'
})
export class AssignmentPDetailComponent implements OnInit {
    assignmentP: IAssignmentP;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ assignmentP }) => {
            this.assignmentP = assignmentP;
        });
    }

    previousState() {
        window.history.back();
    }
}
