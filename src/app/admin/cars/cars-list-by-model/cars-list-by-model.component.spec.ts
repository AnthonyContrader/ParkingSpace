import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CarsListByModelComponent } from './cars-list-by-model.component';

describe('CarsListByModelComponent', () => {
  let component: CarsListByModelComponent;
  let fixture: ComponentFixture<CarsListByModelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CarsListByModelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CarsListByModelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
