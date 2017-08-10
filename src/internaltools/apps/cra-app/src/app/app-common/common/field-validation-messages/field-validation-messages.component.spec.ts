import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FieldValidationMessagesComponent } from './field-validation-messages.component';

describe('FieldValidationMessagesComponent', () => {
  let component: FieldValidationMessagesComponent;
  let fixture: ComponentFixture<FieldValidationMessagesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FieldValidationMessagesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FieldValidationMessagesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
