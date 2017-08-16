import {RequesterInformation} from '../../http-service/domain/requesterinformation';
import {CommonUtils} from '../common/commonutils';
import {FieldValidations} from '../form/validations/fieldvalidations';
import {RequesterValidations} from '../form/validations/requestervalidation';
import {Component, OnInit, Input, Output, EventEmitter} from '@angular/core';
import {ValidatorFn, FormGroup, AbstractControl, FormBuilder} from '@angular/forms';

@Component({
  selector: 'app-requester-information',
  templateUrl: './requester-information.component.html',
  styleUrls: ['./requester-information.component.css']
})
export class RequesterInformationComponent implements OnInit {

  @Input() viewMode: string;
  @Input() inputRequesterInformation: RequesterInformation;
  @Output() requesterOut = new EventEmitter<RequesterInformation>();

  requesterDetailsFromForm: RequesterInformation = null;

  requesterInformationFormGroup: FormGroup;
  controls: {[key: string]: AbstractControl};


  constructor(private fb: FormBuilder) {

  }

  getFieldValue(field: string): string {
    if (this.inputRequesterInformation) {
      switch (field) {
        case 'firstName': {
          return this.inputRequesterInformation.firstName;
        } case 'lastName': {
          return this.inputRequesterInformation.lastName;
        } case 'email': {
          return this.inputRequesterInformation.email;
        } case 'phoneNumber': {
          return this.inputRequesterInformation.phoneNumber;
        }
        default: {
          return '';
        };
      }
    }
    return '';
  }

  getFieldValidations(fieldName: string): ValidatorFn[] {
    return FieldValidations.getFieldValidations(fieldName, RequesterValidations);
  }

  ngOnInit() {
    this.requesterInformationFormGroup = this.fb.group({
      firstName: [this.getFieldValue('firstName'), this.getFieldValidations('firstName')],
      lastName: [this.getFieldValue('lastName'), this.getFieldValidations('lastName')],
      email: [this.getFieldValue('email'), this.getFieldValidations('email')],
      phoneNumber: [this.getFieldValue('phoneNumber'), this.getFieldValidations('phoneNumber')],
    });

    this.controls = this.requesterInformationFormGroup.controls;
  }



  applyValidationStatus(fieldName: string): string {
    if (this.controls[fieldName].touched) {
      if (this.controls[fieldName].valid) {
        return 'has-success';
      }
      return 'has-error';
    }
    return '';
  }

  validateRequesterFormStatus() {

    if (this.requesterInformationFormGroup.valid) {
      this.submitRequesterInformation();
    } else {
      this.requesterOut.emit(null);
    }
  }

  submitRequesterInformation() {
    this.requesterDetailsFromForm = this.buildRequesterDetails();
    console.log('Submit campaign information ' + this.requesterDetailsFromForm);
    this.requesterOut.emit(this.requesterDetailsFromForm);
  }

  buildRequesterDetails(): RequesterInformation {

    const campaignDetails: RequesterInformation = {
      firstName: this.controls['firstName'].value,
      lastName: this.controls['lastName'].value,
      email: this.controls['email'].value,
      phoneNumber: this.controls['phoneNumber'].value,
    }
    return campaignDetails;
  }




  doSubmit(): void {
    console.log('Form Submitted', this.requesterInformationFormGroup.value);
  }

  logTheForm(): void {
    console.log('form: ', this.requesterInformationFormGroup);
  }


}
