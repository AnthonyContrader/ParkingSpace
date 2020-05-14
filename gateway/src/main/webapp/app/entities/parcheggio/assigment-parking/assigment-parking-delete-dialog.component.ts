import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IAssigmentParking } from 'app/shared/model/parcheggio/assigment-parking.model';
import { AssigmentParkingService } from './assigment-parking.service';

@Component({
    selector: 'jhi-assigment-parking-delete-dialog',
    templateUrl: './assigment-parking-delete-dialog.component.html'
})
export class AssigmentParkingDeleteDialogComponent {
    assigmentParking: IAssigmentParking;

    constructor(
        private assigmentParkingService: AssigmentParkingService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.assigmentParkingService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'assigmentParkingListModification',
                content: 'Deleted an assigmentParking'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-assigment-parking-delete-popup',
    template: ''
})
export class AssigmentParkingDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ assigmentParking }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(AssigmentParkingDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.assigmentParking = assigmentParking;
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
