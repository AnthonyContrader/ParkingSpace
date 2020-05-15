/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { GatewayTestModule } from '../../../../test.module';
import { AssignmentParkingUpdateComponent } from 'app/entities/bill/assignment-parking/assignment-parking-update.component';
import { AssignmentParkingService } from 'app/entities/bill/assignment-parking/assignment-parking.service';
import { AssignmentParking } from 'app/shared/model/bill/assignment-parking.model';

describe('Component Tests', () => {
    describe('AssignmentParking Management Update Component', () => {
        let comp: AssignmentParkingUpdateComponent;
        let fixture: ComponentFixture<AssignmentParkingUpdateComponent>;
        let service: AssignmentParkingService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [GatewayTestModule],
                declarations: [AssignmentParkingUpdateComponent]
            })
                .overrideTemplate(AssignmentParkingUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(AssignmentParkingUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(AssignmentParkingService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new AssignmentParking(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.assignmentParking = entity;
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
                    const entity = new AssignmentParking();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.assignmentParking = entity;
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
