
import {CampaignJson} from '../../http-service/domain/campaignJson';
import {CampaignDetails} from '../../http-service/domain/campaigndetails';
import {CampaignValidations} from '../form/validations/campaignvalidations';
import {FieldValidations} from '../form/validations/fieldvalidations';
import {Component, OnInit, Input, Output, EventEmitter} from '@angular/core';
import {FormGroup, FormBuilder, Validators, AbstractControl, ValidatorFn} from '@angular/forms';

@Component({
  selector: 'app-campaign-information',
  templateUrl: './campaign-information.component.html',
  styleUrls: ['./campaign-information.component.css']
})
export class CampaignInformationComponent implements OnInit {

  @Input() viewMode: string;
  @Input() inputCampaignInformation: CampaignDetails;
  @Output() campaignOut = new EventEmitter<CampaignDetails>();

  todayForPrint: number = Date.now();

  campaignDetailsFromForm: CampaignDetails = null;

  campaignInformationFormGroup: FormGroup;
  controls: {[key: string]: AbstractControl};

  selectedFromDate = null;
  selectedToDate = null;
  dateForValidation = null;

  applyValidationStatus(fieldName: string): string {
    if (this.controls[fieldName].touched) {
      if (this.controls[fieldName].valid) {
        return 'has-success';
      }
      return 'has-error';
    }
    return '';
  }

  constructor(private fb: FormBuilder) {

  }

  validateCampaignFormStatus() {

    if (this.campaignInformationFormGroup.valid) {
      this.submitCampaignInformation();
    } else {
      this.campaignOut.emit(null);
    }
  }

  submitCampaignInformation() {
    this.campaignDetailsFromForm = this.buildCampaignDetails();
    console.log('Submit campaign information ' + this.campaignDetailsFromForm);
    this.campaignOut.emit(this.campaignDetailsFromForm);
  }

  buildCampaignDetails(): CampaignDetails {

    const campaignDetails: CampaignDetails = {
      name: this.controls['campaignName'].value,
      stauts: '',
      desc: this.controls['campaignDesc'].value,
      startDate: this.controls['startDate'].value,
      endDate: this.controls['endDate'].value,
      estimatedRevenue: this.controls['estimatedRevenue'].value,
      anyUpdateRequired: this.controls['anyUpdateRequired'].value,
      regionalDirector: this.controls['regionalDirector'].value,
      specialInstructions: this.controls['specialInstructions'].value,
      vendorExists: this.controls['vendorExists'].value,
    }

    return campaignDetails;
  }
  getFieldValidations(fieldName: string): ValidatorFn[] {
    return FieldValidations.getFieldValidations(fieldName, CampaignValidations);
  }

  ngOnInit() {

    this.campaignInformationFormGroup = this.fb.group({
      campaignName: [this.getFieldValue('campaignName'), this.getFieldValidations('campaignName')],
      regionalDirector: [this.getFieldValue('regionalDirector'), this.getFieldValidations('regionalDirector')],
      campaignDesc: [this.getFieldValue('campaignDesc'), this.getFieldValidations('campaignDesc')],
      startDate: [this.getFieldValue('startDate'), this.getFieldValidations('startDate')],
      /*Do common date validation for both start and end date*/
      endDate: [this.getFieldValue('endDate'), this.getFieldValidations('endDate')],
      estimatedRevenue: [this.getFieldValue('estimatedRevenue'), this.getFieldValidations('estimatedRevenue')],
      vendorExists: [this.getFieldValue('vendorExists'), this.getFieldValidations('vendorExists')],
      anyUpdateRequired: [this.getFieldValue('anyUpdateRequired'), this.getFieldValidations('anyUpdateRequired')],
      specialInstructions: [this.getFieldValue('specialInstructions'), this.getFieldValidations('specialInstructions')],
    });

    this.controls = this.campaignInformationFormGroup.controls;
  }

  doSubmit(): void {
    console.log('Form Submitted', this.campaignInformationFormGroup.value);
  }

  logTheForm(): void {
    console.log('form: ', this.campaignInformationFormGroup);
  }

  setToDate(datejson: Date) {
    console.log('To date - ' + datejson);
    this.selectedToDate = datejson.toISOString().slice(0, 10);

    /*
     * Set Both Dates
     */

    this.setDateForValidation();

  }
  setFromDate(datejson: Date) {
    console.log('From date - ' + datejson);
    this.selectedFromDate = datejson.toISOString().slice(0, 10);
    /*
     * Reset To/End Date
     */
    this.selectedToDate = null;

    /*
     * Set Both Dates
     */

    this.setDateForValidation();
  }

  setDateForValidation() {
    if (this.selectedFromDate && this.selectedToDate) {
      this.dateForValidation = `${this.selectedFromDate}/${this.selectedToDate}`;
    }
  }


  getFieldValue(field: string): string {
    if (this.inputCampaignInformation) {
      switch (field) {
        case 'campaignName': {
          return this.inputCampaignInformation.name;
        }
        case 'regionalDirector': {
          return this.inputCampaignInformation.regionalDirector;
        }
        case 'campaignDesc': {
          return this.inputCampaignInformation.desc;
        } case 'startDate': {
          return this.inputCampaignInformation.startDate;
        } case 'endDate': {
          return this.inputCampaignInformation.endDate;
        } case 'estimatedRevenue': {
          return this.inputCampaignInformation.estimatedRevenue;
        } case 'vendorExists': {
          return this.inputCampaignInformation.vendorExists;
        } case 'anyUpdateRequired': {
          return this.inputCampaignInformation.anyUpdateRequired;
        } case 'specialInstructions': {
          return this.inputCampaignInformation.specialInstructions;
        }
        default: {
          return '';
        };
      }
    }
    return '';
  }

}
