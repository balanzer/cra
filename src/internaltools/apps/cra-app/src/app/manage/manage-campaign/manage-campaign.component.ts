
import {CampaignJson} from '../../http-service/domain/campaignJson';
import {CampaignDetails} from '../../http-service/domain/campaigndetails';
import {CRAAppService} from '../../http-service/services/cra/craapp.service';
import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-manage-campaign',
  templateUrl: './manage-campaign.component.html',
  styleUrls: ['./manage-campaign.component.css']
})
export class ManageCampaignComponent implements OnInit {

  campaignDetailForManage: CampaignJson;

  campaignId: number;

  constructor(private craService: CRAAppService, route: ActivatedRoute) {
    route.params.subscribe(params => this.campaignId = params['campaignId']);
    console.log('Get Details for campaignId : ' + this.campaignId);
    this.craService.getByID(this.campaignId);

  }


  ngOnInit() {

    this.craService.getByID(this.campaignId).subscribe(data => {
      this.campaignDetailForManage = data;
    },
      err => {
        console.log('Service error - show message to user');
      });

  }

}

