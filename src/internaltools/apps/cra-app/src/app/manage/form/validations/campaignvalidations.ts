import {FieldInformation} from '../../interface/fieldinformation';
import {RegexValues} from './regexvalues';
import {FormControl} from '@angular/forms';


export const CampaignValidations: FieldInformation[] = [

  {
    fieldName: 'campaignName',
    mandatory: true,
    minimumLength: 6,
    maximumLength: 30,
  }, {
    fieldName: 'regionalDirector',
    mandatory: true,
    minimumLength: 6,
    maximumLength: 40,
    matchesPattern: RegexValues.EMAIL_REGEX,
  }, {
    fieldName: 'campaignDesc',
    mandatory: true,
    minimumLength: 10,
    maximumLength: 2000,
  }, {
    fieldName: 'startDate',
    mandatory: false
  }, {
    fieldName: 'endDate',
    mandatory: false
  }
  , {
    fieldName: 'estimatedRevenue',
    mandatory: true,
    minimumLength: 4,
    maximumLength: 20,
  }, {
    fieldName: 'vendorExists',
    mandatory: false,
    minimumLength: 1,
    maximumLength: 1,
  }, {
    fieldName: 'anyUpdateRequired',
    mandatory: false,
    minimumLength: 1,
    maximumLength: 1,
  }, {
    fieldName: 'specialInstructions',
    mandatory: false,
    minimumLength: 10,
    maximumLength: 2000,
  }, {
    fieldName: 'dateForValidation',
    mandatory: false
  }

];





