/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { GatewayTestModule } from '../../../../test.module';
import { ParkingPlaceUpdateComponent } from 'app/entities/belino1/parking-place/parking-place-update.component';
import { ParkingPlaceService } from 'app/entities/belino1/parking-place/parking-place.service';
import { ParkingPlace } from 'app/shared/model/belino1/parking-place.model';

describe('Component Tests', () => {
    describe('ParkingPlace Management Update Component', () => {
        let comp: ParkingPlaceUpdateComponent;
        let fixture: ComponentFixture<ParkingPlaceUpdateComponent>;
        let service: ParkingPlaceService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [GatewayTestModule],
                declarations: [ParkingPlaceUpdateComponent]
            })
                .overrideTemplate(ParkingPlaceUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(ParkingPlaceUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(ParkingPlaceService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new ParkingPlace(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.parkingPlace = entity;
                    // WHEN
                    comp.save();
                    tick(); // simulate async

                    // THEN
                    expect(service.update).toHaveBeenCalledWith(entity);
                    expect(comp.isSaving).toEqual(false);
                })
            );

            it(
                'Should call create service on save for new entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new ParkingPlace();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.parkingPlace = entity;
                    // WHEN
                    comp.save();
                    tick(); // simulate async

                    // THEN
                    expect(service.create).toHaveBeenCalledWith(entity);
                    expect(comp.isSaving).toEqual(false);
                })
            );
        });
    });
});
