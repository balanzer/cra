import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RequesterInformationComponent } from './requester-information.component';

describe('RequesterInformationComponent', () => {
  let component: RequesterInformationComponent;
  let fixture: ComponentFixture<RequesterInformationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RequesterInformationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RequesterInformationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
