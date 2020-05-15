import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';

import { IAssignmentParking } from 'app/shared/model/bill/assignment-parking.model';
import { AssignmentParkingService } from './assignment-parking.service';

@Component({
    selector: 'jhi-assignment-parking-update',
    templateUrl: './assignment-parking-update.component.html'
})
export class AssignmentParkingUpdateComponent implements OnInit {
    private _assignmentParking: IAssignmentParking;
    isSaving: boolean;
    entryDateTime: string;

    constructor(private assignmentParkingService: AssignmentParkingService, private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ assignmentParking }) => {
            this.assignmentParking = assignmentParking;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        this.assignmentParking.entryDateTime = moment(this.entryDateTime, DATE_TIME_FORMAT);
        if (this.assignmentParking.id !== undefined) {
            this.subscribeToSaveResponse(this.assignmentParkingService.update(this.assignmentParking));
        } else {
            this.subscribeToSaveResponse(this.assignmentParkingService.create(this.assignmentParking));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IAssignmentParking>>) {
        result.subscribe((res: HttpResponse<IAssignmentParking>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }
    get assignmentParking() {
        return this._assignmentParking;
    }

    set assignmentParking(assignmentParking: IAssignmentParking) {
        this._assignmentParking = assignmentParking;
        this.entryDateTime = moment(assignmentParking.entryDateTime).format(DATE_TIME_FORMAT);
    }
}
