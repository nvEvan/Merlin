import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdeptPublicProfileComponent } from './adept-public-profile.component';

describe('AdeptPublicProfileComponent', () => {
  let component: AdeptPublicProfileComponent;
  let fixture: ComponentFixture<AdeptPublicProfileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdeptPublicProfileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdeptPublicProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
