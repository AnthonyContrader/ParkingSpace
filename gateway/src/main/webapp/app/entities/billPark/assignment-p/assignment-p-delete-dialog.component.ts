import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IAssignmentP } from 'app/shared/model/billPark/assignment-p.model';
import { AssignmentPService } from './assignment-p.service';

@Component({
    selector: 'jhi-assignment-p-delete-dialog',
    templateUrl: './assignment-p-delete-dialog.component.html'
})
export class AssignmentPDeleteDialogComponent {
    assignmentP: IAssignmentP;

    constructor(
        private assignmentPService: AssignmentPService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.assignmentPService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'assignmentPListModification',
                content: 'Deleted an assignmentP'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-assignment-p-delete-popup',
    template: ''
})
export class AssignmentPDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ assignmentP }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(AssignmentPDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.assignmentP = assignmentP;
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
