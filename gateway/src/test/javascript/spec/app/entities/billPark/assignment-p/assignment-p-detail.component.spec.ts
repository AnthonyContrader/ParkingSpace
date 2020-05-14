/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { GatewayTestModule } from '../../../../test.module';
import { AssignmentPDetailComponent } from 'app/entities/billPark/assignment-p/assignment-p-detail.component';
import { AssignmentP } from 'app/shared/model/billPark/assignment-p.model';

describe('Component Tests', () => {
    describe('AssignmentP Management Detail Component', () => {
        let comp: AssignmentPDetailComponent;
        let fixture: ComponentFixture<AssignmentPDetailComponent>;
        const route = ({ data: of({ assignmentP: new AssignmentP(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [GatewayTestModule],
                declarations: [AssignmentPDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(AssignmentPDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(AssignmentPDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.assignmentP).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
