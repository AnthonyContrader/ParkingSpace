/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { GatewayTestModule } from '../../../../test.module';
import { AssignmentPDeleteDialogComponent } from 'app/entities/billPark/assignment-p/assignment-p-delete-dialog.component';
import { AssignmentPService } from 'app/entities/billPark/assignment-p/assignment-p.service';

describe('Component Tests', () => {
    describe('AssignmentP Management Delete Component', () => {
        let comp: AssignmentPDeleteDialogComponent;
        let fixture: ComponentFixture<AssignmentPDeleteDialogComponent>;
        let service: AssignmentPService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [GatewayTestModule],
                declarations: [AssignmentPDeleteDialogComponent]
            })
                .overrideTemplate(AssignmentPDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(AssignmentPDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(AssignmentPService);
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
