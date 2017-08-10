import {Component, Output, EventEmitter} from '@angular/core';
import {NgbDateStruct, NgbCalendar} from '@ng-bootstrap/ng-bootstrap';

const now = new Date();

const equals = (one: NgbDateStruct, two: NgbDateStruct) =>
  one && two && two.year === one.year && two.month === one.month && two.day === one.day;

const before = (one: NgbDateStruct, two: NgbDateStruct) =>
  !one || !two ? false : one.year === two.year ? one.month === two.month ? one.day === two.day
    ? false : one.day < two.day : one.month < two.month : one.year < two.year;

const after = (one: NgbDateStruct, two: NgbDateStruct) =>
  !one || !two ? false : one.year === two.year ? one.month === two.month ? one.day === two.day
    ? false : one.day > two.day : one.month > two.month : one.year > two.year;

@Component({
  selector: 'app-ngb-datepicker',
  templateUrl: './ngb-datepicker.component.html',
})
export class NgbDatepickerComponent {

  model;
  displayMonths = 1;
  navigation = 'arrows';
  maxDate;
  minDate;

  fromDate: NgbDateStruct;
  toDate: NgbDateStruct;

  @Output() selectDate = new EventEmitter<Date>();

  constructor(calendar: NgbCalendar) {

    this.minDate = calendar.getToday();
    this.maxDate = calendar.getNext(calendar.getToday(), 'd', 365);

    // this.fromDate = calendar.getToday();
    // this.toDate = calendar.getNext(calendar.getToday(), 'd', 10);
  }
  dateSelected(dateValueJson) {
    const dateSeleccted = new Date(dateValueJson.year, (dateValueJson.month - 1), dateValueJson.day);
    // console.log('Selected Date : ' + dateSeleccted);
    this.selectDate.emit(dateSeleccted);
  }
}
