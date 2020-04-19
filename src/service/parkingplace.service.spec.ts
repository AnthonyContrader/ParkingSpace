import { TestBed } from '@angular/core/testing';

import { ParkingplaceService } from './parkingplace.service';

describe('ParkingplaceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ParkingplaceService = TestBed.get(ParkingplaceService);
    expect(service).toBeTruthy();
  });
});
