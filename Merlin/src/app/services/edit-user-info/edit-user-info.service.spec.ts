import { TestBed, inject } from '@angular/core/testing';

import { EditUserInfoService } from './edit-user-info.service';

describe('EditUserInfoService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [EditUserInfoService]
    });
  });

  it('should be created', inject([EditUserInfoService], (service: EditUserInfoService) => {
    expect(service).toBeTruthy();
  }));
});
