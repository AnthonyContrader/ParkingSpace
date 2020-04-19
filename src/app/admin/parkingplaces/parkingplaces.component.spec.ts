import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ParkingplacesComponent } from './parkingplaces.component';

describe('ParkingplacesComponent', () => {
  let component: ParkingplacesComponent;
  let fixture: ComponentFixture<ParkingplacesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ParkingplacesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ParkingplacesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
