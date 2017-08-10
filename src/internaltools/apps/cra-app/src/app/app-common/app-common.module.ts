import {FieldRequiredFlagComponent} from './common/field-required-flag/field-required-flag.component';
import {FieldValidationIconsComponent} from './common/field-validation-icons/field-validation-icons.component';
import {FieldValidationMessagesComponent} from './common/field-validation-messages/field-validation-messages.component';
import {NgbDatepickerComponent} from './common/ngb-datepicker/ngb-datepicker.component';



import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HeaderComponent} from './header/header.component';
import {FooterComponent} from './footer/footer.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';


@NgModule({
  imports: [
    CommonModule, FormsModule, ReactiveFormsModule, NgbModule.forRoot()
  ],
  declarations: [
    HeaderComponent,
    FooterComponent,
    FieldRequiredFlagComponent,
    FieldValidationIconsComponent,
    FieldValidationMessagesComponent,
    NgbDatepickerComponent
  ],
  exports: [
    HeaderComponent,
    FooterComponent,
    FieldRequiredFlagComponent,
    FieldValidationIconsComponent,
    FieldValidationMessagesComponent,
    NgbDatepickerComponent
  ]
})
export class AppCommonModule {}
