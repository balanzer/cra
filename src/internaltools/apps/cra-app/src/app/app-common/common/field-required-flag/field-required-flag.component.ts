import {Component, OnInit, Input} from '@angular/core';

@Component({
  selector: 'app-field-required-flag',
  templateUrl: './field-required-flag.component.html',
  styleUrls: ['./field-required-flag.component.css']
})
export class FieldRequiredFlagComponent implements OnInit {

  @Input() requiredFlag: boolean;

  constructor() {}

  ngOnInit() {
  }

}
