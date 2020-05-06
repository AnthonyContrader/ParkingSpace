import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IParkingPlace } from 'app/shared/model/belino1/parking-place.model';
import { ParkingPlaceService } from './parking-place.service';

@Component({
    selector: 'jhi-parking-place-delete-dialog',
    templateUrl: './parking-place-delete-dialog.component.html'
})
export class ParkingPlaceDeleteDialogComponent {
    parkingPlace: IParkingPlace;

    constructor(
        private parkingPlaceService: ParkingPlaceService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.parkingPlaceService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'parkingPlaceListModification',
                content: 'Deleted an parkingPlace'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-parking-place-delete-popup',
    template: ''
})
export class ParkingPlaceDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ parkingPlace }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(ParkingPlaceDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.parkingPlace = parkingPlace;
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
