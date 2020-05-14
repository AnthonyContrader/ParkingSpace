import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { ICar } from 'app/shared/model/parcheggio/car.model';
import { CarService } from './car.service';
import { IPerson } from 'app/shared/model/parcheggio/person.model';
import { PersonService } from 'app/entities/parcheggio/person';

@Component({
    selector: 'jhi-car-update',
    templateUrl: './car-update.component.html'
})
export class CarUpdateComponent implements OnInit {
    private _car: ICar;
    isSaving: boolean;

    people: IPerson[];

    constructor(
        private jhiAlertService: JhiAlertService,
        private carService: CarService,
        private personService: PersonService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ car }) => {
            this.car = car;
        });
        this.personService.query().subscribe(
            (res: HttpResponse<IPerson[]>) => {
                this.people = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.car.id !== undefined) {
            this.subscribeToSaveResponse(this.carService.update(this.car));
        } else {
            this.subscribeToSaveResponse(this.carService.create(this.car));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<ICar>>) {
        result.subscribe((res: HttpResponse<ICar>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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

    trackPersonById(index: number, item: IPerson) {
        return item.id;
    }
    get car() {
        return this._car;
    }

    set car(car: ICar) {
        this._car = car;
    }
}
