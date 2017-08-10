import {Component, OnInit, Input} from '@angular/core';
import {AbstractControl} from '@angular/forms';

@Component({
  selector: 'app-field-validation-messages',
  templateUrl: './field-validation-messages.component.html',
  styleUrls: ['./field-validation-messages.component.css']
})
export class FieldValidationMessagesComponent implements OnInit {


  @Input() fieldControl: AbstractControl;
  @Input() fieldLabel: string;


  constructor() {}

  ngOnInit() {
  }

}
