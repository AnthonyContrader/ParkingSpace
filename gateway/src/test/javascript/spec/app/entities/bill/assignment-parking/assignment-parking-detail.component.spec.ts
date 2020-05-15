/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { GatewayTestModule } from '../../../../test.module';
import { AssignmentParkingDetailComponent } from 'app/entities/bill/assignment-parking/assignment-parking-detail.component';
import { AssignmentParking } from 'app/shared/model/bill/assignment-parking.model';

describe('Component Tests', () => {
    describe('AssignmentParking Management Detail Component', () => {
        let comp: AssignmentParkingDetailComponent;
        let fixture: ComponentFixture<AssignmentParkingDetailComponent>;
        const route = ({ data: of({ assignmentParking: new AssignmentParking(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [GatewayTestModule],
                declarations: [AssignmentParkingDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(AssignmentParkingDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(AssignmentParkingDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.assignmentParking).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
