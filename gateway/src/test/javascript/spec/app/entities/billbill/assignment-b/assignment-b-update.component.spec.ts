/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { GatewayTestModule } from '../../../../test.module';
import { AssignmentBUpdateComponent } from 'app/entities/billbill/assignment-b/assignment-b-update.component';
import { AssignmentBService } from 'app/entities/billbill/assignment-b/assignment-b.service';
import { AssignmentB } from 'app/shared/model/billbill/assignment-b.model';

describe('Component Tests', () => {
    describe('AssignmentB Management Update Component', () => {
        let comp: AssignmentBUpdateComponent;
        let fixture: ComponentFixture<AssignmentBUpdateComponent>;
        let service: AssignmentBService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [GatewayTestModule],
                declarations: [AssignmentBUpdateComponent]
            })
                .overrideTemplate(AssignmentBUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(AssignmentBUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(AssignmentBService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new AssignmentB(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.assignmentB = entity;
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
                    const entity = new AssignmentB();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.assignmentB = entity;
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
