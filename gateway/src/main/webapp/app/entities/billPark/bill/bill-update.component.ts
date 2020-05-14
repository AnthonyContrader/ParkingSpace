import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { IBill } from 'app/shared/model/billPark/bill.model';
import { BillService } from './bill.service';
import { IAssignmentP } from 'app/shared/model/billPark/assignment-p.model';
import { AssignmentPService } from 'app/entities/billPark/assignment-p';

@Component({
    selector: 'jhi-bill-update',
    templateUrl: './bill-update.component.html'
})
export class BillUpdateComponent implements OnInit {
    private _bill: IBill;
    isSaving: boolean;

    assignments: IAssignmentP[];

    constructor(
        private jhiAlertService: JhiAlertService,
        private billService: BillService,
        private assignmentPService: AssignmentPService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ bill }) => {
            this.bill = bill;
        });
        this.assignmentPService.query({ filter: 'bill-is-null' }).subscribe(
            (res: HttpResponse<IAssignmentP[]>) => {
                if (!this.bill.assignmentId) {
                    this.assignments = res.body;
                } else {
                    this.assignmentPService.find(this.bill.assignmentId).subscribe(
                        (subRes: HttpResponse<IAssignmentP>) => {
                            this.assignments = [subRes.body].concat(res.body);
                        },
                        (subRes: HttpErrorResponse) => this.onError(subRes.message)
                    );
                }
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.bill.id !== undefined) {
            this.subscribeToSaveResponse(this.billService.update(this.bill));
        } else {
            this.subscribeToSaveResponse(this.billService.create(this.bill));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IBill>>) {
        result.subscribe((res: HttpResponse<IBill>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }

    trackAssignmentPById(index: number, item: IAssignmentP) {
        return item.id;
    }
    get bill() {
        return this._bill;
    }

    set bill(bill: IBill) {
        this._bill = bill;
    }
}
