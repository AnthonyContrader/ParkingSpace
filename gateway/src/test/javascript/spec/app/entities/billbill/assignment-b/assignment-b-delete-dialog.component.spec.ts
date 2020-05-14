/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { GatewayTestModule } from '../../../../test.module';
import { AssignmentBDeleteDialogComponent } from 'app/entities/billbill/assignment-b/assignment-b-delete-dialog.component';
import { AssignmentBService } from 'app/entities/billbill/assignment-b/assignment-b.service';

describe('Component Tests', () => {
    describe('AssignmentB Management Delete Component', () => {
        let comp: AssignmentBDeleteDialogComponent;
        let fixture: ComponentFixture<AssignmentBDeleteDialogComponent>;
        let service: AssignmentBService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [GatewayTestModule],
                declarations: [AssignmentBDeleteDialogComponent]
            })
                .overrideTemplate(AssignmentBDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(AssignmentBDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(AssignmentBService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('confirmDelete', () => {
            it('Should call delete service on confirmDelete', inject(
                [],
                fakeAsync(() => {
                    // GIVEN
                    spyOn(service, 'delete').and.returnValue(of({}));

                    // WHEN
                    comp.confirmDelete(123);
                    tick();

                    // THEN
                    expect(service.delete).toHaveBeenCalledWith(123);
                    expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
                })
            ));
        });
    });
});
