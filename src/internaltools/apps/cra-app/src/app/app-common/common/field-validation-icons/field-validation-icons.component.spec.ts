import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FieldValidationIconsComponent } from './field-validation-icons.component';

describe('FieldValidationIconsComponent', () => {
  let component: FieldValidationIconsComponent;
  let fixture: ComponentFixture<FieldValidationIconsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FieldValidationIconsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FieldValidationIconsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
