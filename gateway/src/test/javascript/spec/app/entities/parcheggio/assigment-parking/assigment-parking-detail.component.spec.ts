/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { GatewayTestModule } from '../../../../test.module';
import { AssigmentParkingDetailComponent } from 'app/entities/parcheggio/assigment-parking/assigment-parking-detail.component';
import { AssigmentParking } from 'app/shared/model/parcheggio/assigment-parking.model';

describe('Component Tests', () => {
    describe('AssigmentParking Management Detail Component', () => {
        let comp: AssigmentParkingDetailComponent;
        let fixture: ComponentFixture<AssigmentParkingDetailComponent>;
        const route = ({ data: of({ assigmentParking: new AssigmentParking(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [GatewayTestModule],
                declarations: [AssigmentParkingDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(AssigmentParkingDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(AssigmentParkingDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.assigmentParking).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
