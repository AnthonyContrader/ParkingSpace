/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { GatewayTestModule } from '../../../../test.module';
import { AssignmentPUpdateComponent } from 'app/entities/billPark/assignment-p/assignment-p-update.component';
import { AssignmentPService } from 'app/entities/billPark/assignment-p/assignment-p.service';
import { AssignmentP } from 'app/shared/model/billPark/assignment-p.model';

describe('Component Tests', () => {
    describe('AssignmentP Management Update Component', () => {
        let comp: AssignmentPUpdateComponent;
        let fixture: ComponentFixture<AssignmentPUpdateComponent>;
        let service: AssignmentPService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [GatewayTestModule],
                declarations: [AssignmentPUpdateComponent]
            })
                .overrideTemplate(AssignmentPUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(AssignmentPUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(AssignmentPService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new AssignmentP(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.assignmentP = entity;
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
                    const entity = new AssignmentP();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.assignmentP = entity;
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
