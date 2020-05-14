/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { GatewayTestModule } from '../../../../test.module';
import { AssignmentBDetailComponent } from 'app/entities/billbill/assignment-b/assignment-b-detail.component';
import { AssignmentB } from 'app/shared/model/billbill/assignment-b.model';

describe('Component Tests', () => {
    describe('AssignmentB Management Detail Component', () => {
        let comp: AssignmentBDetailComponent;
        let fixture: ComponentFixture<AssignmentBDetailComponent>;
        const route = ({ data: of({ assignmentB: new AssignmentB(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [GatewayTestModule],
                declarations: [AssignmentBDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(AssignmentBDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(AssignmentBDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.assignmentB).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
