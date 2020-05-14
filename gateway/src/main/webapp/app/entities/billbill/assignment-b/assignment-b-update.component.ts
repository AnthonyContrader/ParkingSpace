import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';

import { IAssignmentB } from 'app/shared/model/billbill/assignment-b.model';
import { AssignmentBService } from './assignment-b.service';

@Component({
    selector: 'jhi-assignment-b-update',
    templateUrl: './assignment-b-update.component.html'
})
export class AssignmentBUpdateComponent implements OnInit {
    private _assignmentB: IAssignmentB;
    isSaving: boolean;
    entryDateTime: string;

    constructor(private assignmentBService: AssignmentBService, private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ assignmentB }) => {
            this.assignmentB = assignmentB;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        this.assignmentB.entryDateTime = moment(this.entryDateTime, DATE_TIME_FORMAT);
        if (this.assignmentB.id !== undefined) {
            this.subscribeToSaveResponse(this.assignmentBService.update(this.assignmentB));
        } else {
            this.subscribeToSaveResponse(this.assignmentBService.create(this.assignmentB));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IAssignmentB>>) {
        result.subscribe((res: HttpResponse<IAssignmentB>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }
    get assignmentB() {
        return this._assignmentB;
    }

    set assignmentB(assignmentB: IAssignmentB) {
        this._assignmentB = assignmentB;
        this.entryDateTime = moment(assignmentB.entryDateTime).format(DATE_TIME_FORMAT);
    }
}
