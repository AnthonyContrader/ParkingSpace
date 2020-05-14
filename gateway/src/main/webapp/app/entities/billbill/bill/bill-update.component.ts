import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { IBill } from 'app/shared/model/billbill/bill.model';
import { BillService } from './bill.service';
import { IAssignmentB } from 'app/shared/model/billbill/assignment-b.model';
import { AssignmentBService } from 'app/entities/billbill/assignment-b';

@Component({
    selector: 'jhi-bill-update',
    templateUrl: './bill-update.component.html'
})
export class BillUpdateComponent implements OnInit {
    private _bill: IBill;
    isSaving: boolean;

    assignmentbs: IAssignmentB[];

    constructor(
        private jhiAlertService: JhiAlertService,
        private billService: BillService,
        private assignmentBService: AssignmentBService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ bill }) => {
            this.bill = bill;
        });
        this.assignmentBService.query({ filter: 'bill-is-null' }).subscribe(
            (res: HttpResponse<IAssignmentB[]>) => {
                if (!this.bill.assignmentbId) {
                    this.assignmentbs = res.body;
                } else {
                    this.assignmentBService.find(this.bill.assignmentbId).subscribe(
                        (subRes: HttpResponse<IAssignmentB>) => {
                            this.assignmentbs = [subRes.body].concat(res.body);
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

    trackAssignmentBById(index: number, item: IAssignmentB) {
        return item.id;
    }
    get bill() {
        return this._bill;
    }

    set bill(bill: IBill) {
        this._bill = bill;
    }
}
