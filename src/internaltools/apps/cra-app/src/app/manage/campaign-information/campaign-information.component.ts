
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
  @Output() campaignOut = new EventEmitter<CampaignDetails>();

  campaignDetailsFromForm: CampaignDetails = null;

  campaignInformationFormGroup: FormGroup;
  controls: {[key: string]: AbstractControl};

  selectedFromDate = null;
  selectedToDate = null;
  dateForValidation = null;

  constructor(fb: FormBuilder) {
    this.campaignInformationFormGroup = fb.group({
      campaignName: ['Sample Campaign Name', this.getFieldValidations('campaignName')],
      regionalDirector: ['m.v@ihg.com', this.getFieldValidations('regionalDirector')],
      campaignDesc: ['Big Desc about campaign goes here', this.getFieldValidations('campaignDesc')],
      startDate: ['', this.getFieldValidations('dateForValidation')], /*Do common date validation for both start and end date*/
      endDate: ['', this.getFieldValidations('dateForValidation')],
      dateForValidation: ['', this.getFieldValidations('dateForValidation')],
      /*Hidden field does custom validation when both date fields are set */
      estimatedRevenue: ['$1.23 USD', this.getFieldValidations('estimatedRevenue')],
      vendorExists: ['', this.getFieldValidations('vendorExists')],
      anyUpdateRequired: ['', this.getFieldValidations('anyUpdateRequired')],
      specialInstructions: ['', this.getFieldValidations('specialInstructions')],
    });

    this.controls = this.campaignInformationFormGroup.controls;
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
}
