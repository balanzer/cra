

import {Component, OnInit} from '@angular/core';

import {CRAAppService} from '../../http-service/services/cra/craapp.service';
import {CampaignDetails} from '../../http-service/domain/campaigndetails';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-list-records',
  templateUrl: './list-records.component.html',
  styleUrls: ['./list-records.component.css']
})
export class ListRecordsComponent implements OnInit {


  
  errorMessage:string ; 
  
  //campaignDetails$: Observable<CampaignDetails[]>;
  campaignDetails:CampaignDetails[];

  constructor(private craService: CRAAppService) {

  }


  ngOnInit() {
    // this.campaignDetails$ = this.craService.getAll();


    this.craService.getAll().subscribe(data => {
      console.log('Data : ' + data);
      this.campaignDetails = data;
    },
      err => {
        console.log('Service error - show message to user');
        this.errorMessage="List operation failed. Service unavailable.";
      });

  }
}
