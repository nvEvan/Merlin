import { TestBed, inject } from '@angular/core/testing';

import { UserPrivateInfoService } from './user-private-info.service';

describe('UserPrivateInfoService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [UserPrivateInfoService]
    });
  });

  it('should be created', inject([UserPrivateInfoService], (service: UserPrivateInfoService) => {
    expect(service).toBeTruthy();
  }));
});
