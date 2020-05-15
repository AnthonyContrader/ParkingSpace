/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { GatewayTestModule } from '../../../../test.module';
import { AssigmentParkingUpdateComponent } from 'app/entities/parkingspace/assigment-parking/assigment-parking-update.component';
import { AssigmentParkingService } from 'app/entities/parkingspace/assigment-parking/assigment-parking.service';
import { AssigmentParking } from 'app/shared/model/parkingspace/assigment-parking.model';

describe('Component Tests', () => {
    describe('AssigmentParking Management Update Component', () => {
        let comp: AssigmentParkingUpdateComponent;
        let fixture: ComponentFixture<AssigmentParkingUpdateComponent>;
        let service: AssigmentParkingService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [GatewayTestModule],
                declarations: [AssigmentParkingUpdateComponent]
            })
                .overrideTemplate(AssigmentParkingUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(AssigmentParkingUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(AssigmentParkingService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new AssigmentParking(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.assigmentParking = entity;
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
                    const entity = new AssigmentParking();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.assigmentParking = entity;
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
