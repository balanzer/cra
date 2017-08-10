import {CampaignJson} from '../../http-service/domain/campaignJson';
import {CampaignDetails} from '../../http-service/domain/campaigndetails';
import {RequesterInformation} from '../../http-service/domain/requesterinformation';
import {CRAAppService} from '../../http-service/services/cra/craapp.service';
import {Component, OnInit} from '@angular/core';
import {Http, Headers, Request, RequestOptions, RequestMethod, HttpModule} from '@angular/http';
@Component({
  selector: 'app-manage-campaign',
  templateUrl: './manage-campaign.component.html',
  styleUrls: ['./manage-campaign.component.css']
})
export class ManageCampaignComponent implements OnInit {

  finalFormValidStatus = false;
  campaignDetails: CampaignDetails = null;
  requesterDetails: RequesterInformation = null;

  constructor(private craService: CRAAppService) {}

  ngOnInit() {
  }


  setCampaignInformation(campaignInfo: CampaignDetails) {
    console.log('set completed campaign details');
    this.campaignDetails = campaignInfo;
    this.validateFinalFormStaus();
  }

  setRequesterInformation(requesterInfo: RequesterInformation) {
    console.log('set completed requester details');
    this.requesterDetails = requesterInfo;
    this.validateFinalFormStaus();
  }


  validateFinalFormStaus() {
    // Check for all information like campaign, requester, brands & others.
    // when true submit button will be enabled

    if (this.campaignDetails && this.requesterDetails) {
      this.finalFormValidStatus = true;
    } else {
      this.finalFormValidStatus = false;
    }
  }


  logCompleteInformation() {
    console.log('Complete information will be added');
  }
  createCampaign() {

    const newCampaignRecord: CampaignJson = {
      name: this.campaignDetails.name,
      stauts: this.campaignDetails.stauts,
      desc: this.campaignDetails.desc,
      startDate: this.campaignDetails.startDate,
      endDate: this.campaignDetails.endDate,
      estimatedRevenue: this.campaignDetails.estimatedRevenue,
      anyUpdateRequired: this.campaignDetails.anyUpdateRequired,
      regionalDirector: this.campaignDetails.regionalDirector,
      specialInstructions: this.campaignDetails.specialInstructions,
      vendorExists: this.campaignDetails.vendorExists,
      requester: this.requesterDetails
    }


    this.craService.create(newCampaignRecord).subscribe(this.campaignResponse, err => {
      console.log('Something went wrong!');
    });
  }


  campaignResponse(data: string) {
    console.log('New Record Created location : ' + data);
  }
}
