import { TestBed, inject } from '@angular/core/testing';

import { AdeptIdService } from './adept-id.service';

describe('AdeptIdService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AdeptIdService]
    });
  });

  it('should be created', inject([AdeptIdService], (service: AdeptIdService) => {
    expect(service).toBeTruthy();
  }));
});
