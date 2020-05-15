import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { JhiAlertService } from 'ng-jhipster';

import { IAssigmentParking } from 'app/shared/model/parkingspace/assigment-parking.model';
import { AssigmentParkingService } from './assigment-parking.service';
import { ICar } from 'app/shared/model/parkingspace/car.model';
import { CarService } from 'app/entities/parkingspace/car';
import { IParkingPlace } from 'app/shared/model/parkingspace/parking-place.model';
import { ParkingPlaceService } from 'app/entities/parkingspace/parking-place';

@Component({
    selector: 'jhi-assigment-parking-update',
    templateUrl: './assigment-parking-update.component.html'
})
export class AssigmentParkingUpdateComponent implements OnInit {
    private _assigmentParking: IAssigmentParking;
    isSaving: boolean;

    cars: ICar[];

    parkingplaces: IParkingPlace[];
    entryDateTime: string;

    constructor(
        private jhiAlertService: JhiAlertService,
        private assigmentParkingService: AssigmentParkingService,
        private carService: CarService,
        private parkingPlaceService: ParkingPlaceService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ assigmentParking }) => {
            this.assigmentParking = assigmentParking;
        });
        this.carService.query({ filter: 'assigmentparking-is-null' }).subscribe(
            (res: HttpResponse<ICar[]>) => {
                if (!this.assigmentParking.carId) {
                    this.cars = res.body;
                } else {
                    this.carService.find(this.assigmentParking.carId).subscribe(
                        (subRes: HttpResponse<ICar>) => {
                            this.cars = [subRes.body].concat(res.body);
                        },
                        (subRes: HttpErrorResponse) => this.onError(subRes.message)
                    );
                }
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
        this.parkingPlaceService.query({ filter: 'assigmentparking-is-null' }).subscribe(
            (res: HttpResponse<IParkingPlace[]>) => {
                if (!this.assigmentParking.parkingplaceId) {
                    this.parkingplaces = res.body;
                } else {
                    this.parkingPlaceService.find(this.assigmentParking.parkingplaceId).subscribe(
                        (subRes: HttpResponse<IParkingPlace>) => {
                            this.parkingplaces = [subRes.body].concat(res.body);
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
        this.assigmentParking.entryDateTime = moment(this.entryDateTime, DATE_TIME_FORMAT);
        if (this.assigmentParking.id !== undefined) {
            this.subscribeToSaveResponse(this.assigmentParkingService.update(this.assigmentParking));
        } else {
            this.subscribeToSaveResponse(this.assigmentParkingService.create(this.assigmentParking));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IAssigmentParking>>) {
        result.subscribe((res: HttpResponse<IAssigmentParking>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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

    trackCarById(index: number, item: ICar) {
        return item.id;
    }

    trackParkingPlaceById(index: number, item: IParkingPlace) {
        return item.id;
    }
    get assigmentParking() {
        return this._assigmentParking;
    }

    set assigmentParking(assigmentParking: IAssigmentParking) {
        this._assigmentParking = assigmentParking;
        this.entryDateTime = moment(assigmentParking.entryDateTime).format(DATE_TIME_FORMAT);
    }
}
