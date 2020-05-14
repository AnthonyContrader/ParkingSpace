import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IAssignmentB } from 'app/shared/model/billbill/assignment-b.model';
import { AssignmentBService } from './assignment-b.service';

@Component({
    selector: 'jhi-assignment-b-delete-dialog',
    templateUrl: './assignment-b-delete-dialog.component.html'
})
export class AssignmentBDeleteDialogComponent {
    assignmentB: IAssignmentB;

    constructor(
        private assignmentBService: AssignmentBService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.assignmentBService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'assignmentBListModification',
                content: 'Deleted an assignmentB'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-assignment-b-delete-popup',
    template: ''
})
export class AssignmentBDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ assignmentB }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(AssignmentBDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.assignmentB = assignmentB;
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
