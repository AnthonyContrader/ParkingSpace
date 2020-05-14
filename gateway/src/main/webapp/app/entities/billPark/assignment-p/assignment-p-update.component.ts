import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';

import { IAssignmentP } from 'app/shared/model/billPark/assignment-p.model';
import { AssignmentPService } from './assignment-p.service';

@Component({
    selector: 'jhi-assignment-p-update',
    templateUrl: './assignment-p-update.component.html'
})
export class AssignmentPUpdateComponent implements OnInit {
    private _assignmentP: IAssignmentP;
    isSaving: boolean;
    entryDateTime: string;

    constructor(private assignmentPService: AssignmentPService, private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ assignmentP }) => {
            this.assignmentP = assignmentP;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        this.assignmentP.entryDateTime = moment(this.entryDateTime, DATE_TIME_FORMAT);
        if (this.assignmentP.id !== undefined) {
            this.subscribeToSaveResponse(this.assignmentPService.update(this.assignmentP));
        } else {
            this.subscribeToSaveResponse(this.assignmentPService.create(this.assignmentP));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IAssignmentP>>) {
        result.subscribe((res: HttpResponse<IAssignmentP>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }
    get assignmentP() {
        return this._assignmentP;
    }

    set assignmentP(assignmentP: IAssignmentP) {
        this._assignmentP = assignmentP;
        this.entryDateTime = moment(assignmentP.entryDateTime).format(DATE_TIME_FORMAT);
    }
}
