import {FieldInformation} from '../../interface/fieldinformation';
import {RegexValues} from './regexvalues';
import {FormControl} from '@angular/forms';


export const RequesterValidations: FieldInformation[] = [
  {
    fieldName: 'firstName',
    mandatory: true,
    minimumLength: 2,
    maximumLength: 30,
  },
  {
    fieldName: 'lastName',
    mandatory: true,
    minimumLength: 2,
    maximumLength: 30,
  }, {
    fieldName: 'email',
    mandatory: true,
    minimumLength: 6,
    maximumLength: 40,
    matchesPattern: RegexValues.EMAIL_REGEX,
  }, {
    fieldName: 'phoneNumber',
    mandatory: true,
    minimumLength: 6,
    maximumLength: 15,
  }];

