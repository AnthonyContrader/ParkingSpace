import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { IParkingPlace } from 'app/shared/model/parcheggio/parking-place.model';
import { ParkingPlaceService } from './parking-place.service';
import { IFloor } from 'app/shared/model/parcheggio/floor.model';
import { FloorService } from 'app/entities/parcheggio/floor';

@Component({
    selector: 'jhi-parking-place-update',
    templateUrl: './parking-place-update.component.html'
})
export class ParkingPlaceUpdateComponent implements OnInit {
    private _parkingPlace: IParkingPlace;
    isSaving: boolean;

    floors: IFloor[];

    constructor(
        private jhiAlertService: JhiAlertService,
        private parkingPlaceService: ParkingPlaceService,
        private floorService: FloorService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ parkingPlace }) => {
            this.parkingPlace = parkingPlace;
        });
        this.floorService.query().subscribe(
            (res: HttpResponse<IFloor[]>) => {
                this.floors = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.parkingPlace.id !== undefined) {
            this.subscribeToSaveResponse(this.parkingPlaceService.update(this.parkingPlace));
        } else {
            this.subscribeToSaveResponse(this.parkingPlaceService.create(this.parkingPlace));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IParkingPlace>>) {
        result.subscribe((res: HttpResponse<IParkingPlace>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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

    trackFloorById(index: number, item: IFloor) {
        return item.id;
    }
    get parkingPlace() {
        return this._parkingPlace;
    }

    set parkingPlace(parkingPlace: IParkingPlace) {
        this._parkingPlace = parkingPlace;
    }
}
