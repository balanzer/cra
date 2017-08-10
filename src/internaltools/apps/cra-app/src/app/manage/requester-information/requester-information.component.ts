import {RequesterInformation} from '../../http-service/domain/requesterinformation';
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
  @Output() requesterOut = new EventEmitter<RequesterInformation>();

  requesterDetailsFromForm: RequesterInformation = null;

  requesterInformationFormGroup: FormGroup;
  controls: {[key: string]: AbstractControl};


  constructor(fb: FormBuilder) {
    this.requesterInformationFormGroup = fb.group({
      firstName: ['', this.getFieldValidations('firstName')],
      lastName: ['Varath', this.getFieldValidations('lastName')],
      email: ['m.v@ihg.com', this.getFieldValidations('email')],
      phoneNumber: ['123-123-123', this.getFieldValidations('phoneNumber')],
    });

    this.controls = this.requesterInformationFormGroup.controls;

  }

  getFieldValidations(fieldName: string): ValidatorFn[] {
    return FieldValidations.getFieldValidations(fieldName, RequesterValidations);
  }

  ngOnInit() {
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
