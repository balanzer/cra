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
    mandatory: true,
    minimumLength: 10,
    maximumLength: 10,
    matchesPattern: RegexValues.DATE_FORMAT,

  }, {
    fieldName: 'endDate',
    mandatory: true,
    minimumLength: 10,
    maximumLength: 10,
    matchesPattern: RegexValues.DATE_FORMAT,
  }
  , {
    fieldName: 'estimatedRevenue',
    mandatory: true,
    minimumLength: 4,
    maximumLength: 20,
  }, {
    fieldName: 'vendorExists',
    mandatory: true,
    minimumLength: 1,
    maximumLength: 1,
  }, {
    fieldName: 'anyUpdateRequired',
    mandatory: true,
    minimumLength: 1,
    maximumLength: 1,
  }, {
    fieldName: 'specialInstructions',
    mandatory: false,
    minimumLength: 10,
    maximumLength: 2000,
  }

];





