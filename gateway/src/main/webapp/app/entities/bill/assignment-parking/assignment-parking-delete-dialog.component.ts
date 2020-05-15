import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IAssignmentParking } from 'app/shared/model/bill/assignment-parking.model';
import { AssignmentParkingService } from './assignment-parking.service';

@Component({
    selector: 'jhi-assignment-parking-delete-dialog',
    templateUrl: './assignment-parking-delete-dialog.component.html'
})
export class AssignmentParkingDeleteDialogComponent {
    assignmentParking: IAssignmentParking;

    constructor(
        private assignmentParkingService: AssignmentParkingService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.assignmentParkingService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'assignmentParkingListModification',
                content: 'Deleted an assignmentParking'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-assignment-parking-delete-popup',
    template: ''
})
export class AssignmentParkingDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ assignmentParking }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(AssignmentParkingDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.assignmentParking = assignmentParking;
                this.ngbModalRef.result.then(
                    result => {
                        this.router.navigate([{ outlets: { popup: null } }], { replaceUrl: true, queryParamsHandling: 'merge' });
                        this.ngbModalRef = null;
                    },
                    reason => {
                        this.router.navigate([{ outlets: { popup: null } }], { replaceUrl: true, queryParamsHandling: 'merge' });
                        this.ngbModalRef = null;
                    }
                );
            }, 0);
        });
    }

    ngOnDestroy() {
        this.ngbModalRef = null;
    }
}
