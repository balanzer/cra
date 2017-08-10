import {Component, OnInit, Input} from '@angular/core';
import {AbstractControl} from '@angular/forms';

@Component({
  selector: 'app-field-validation-icons',
  templateUrl: './field-validation-icons.component.html',
  styleUrls: ['./field-validation-icons.component.css']
})
export class FieldValidationIconsComponent implements OnInit {

  @Input() fieldControl: AbstractControl;
  @Input() fieldLabel: string;


  constructor() {}

  ngOnInit() {
  }

}
