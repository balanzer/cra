import {FieldInformation} from '../../interface/fieldinformation';
import {ValidatorFn, Validators, FormControl, AbstractControl} from '@angular/forms';


export class FieldValidations {
  static getFieldValidations(fieldName: string, validations: FieldInformation[]): ValidatorFn[] {

    const fieldValidators: ValidatorFn[] = [];

    validations.forEach((fieldinfo: any) => {



      if (fieldinfo.fieldName === fieldName) {
        if (fieldinfo.mandatory) {
          fieldValidators.push(Validators.required);
        }

        if (fieldinfo.minimumLength) {
          fieldValidators.push(
            Validators.minLength(fieldinfo.minimumLength)
          );
        }

        if (fieldinfo.maximumLength) {
          fieldValidators.push(
            Validators.maxLength(fieldinfo.maximumLength)
          );
        }

        if (fieldinfo.matchesPattern) {
          fieldValidators.push(
            Validators.pattern(fieldinfo.matchesPattern)
          );
        }

        fieldValidators.push(noWhiteSpaceError);


        /**
         * Add any special validation by fields
         * E.g. Date Validation for from and To date using custom field dateForValidation
         */

        if ('dateForValidation' === fieldName) {
          fieldValidators.push(dateValidationStartEndDate);
        }


      }
    });


    return fieldValidators;
  }

}

function noWhiteSpaceError(control: FormControl) {

  const isNoSameAfterTrimValue = (control.value || '').trim().length === (control.value || '').length;
  const isValid = isNoSameAfterTrimValue;
  return isValid ? null : {'whitespace': true}
}

function dateValidationStartEndDate(control: FormControl) {
  const dateValue: string = (control.value || '').trim();

  const isValid = true;
  /*
   * Input Date format yyyy-MM-dd
   * Year in Pos 0
   * Mon in Pos 1
   * Day in Pos 2
   */


  if (dateValue.length !== 0 && dateValue.split('/').length === 2) {
    const dates: string[] = dateValue.split('/');

    const fromDateStr: string[] = dates[0].split('-');
    const toDateStr: string[] = dates[1].split('-');
    const today = new Date();
    const fromDate = new Date(parseInt(fromDateStr[0]), (parseInt(fromDateStr[1]) - 1), parseInt(fromDateStr[2]));
    const toDate = new Date(parseInt(toDateStr[0]), (parseInt(toDateStr[1]) - 1), parseInt(toDateStr[2]));

    if (fromDate < today || toDate < toDate) {
      return {'lessthantoday': true}
    } else if (fromDate > toDate) {
      return {'fromafterto': true}
    }
  }
  return null;
}


