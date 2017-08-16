
import {CampaignJson} from '../../http-service/domain/campaignJson';
import {CampaignDetails} from '../../http-service/domain/campaigndetails';
import {RequesterInformation} from '../../http-service/domain/requesterinformation';
import {CRAAppService} from '../../http-service/services/cra/craapp.service';
import {Component, OnInit, Input} from '@angular/core';
import {Http, Headers, Request, RequestOptions, RequestMethod, HttpModule} from '@angular/http';
@Component({
  selector: 'app-campaign-details',
  templateUrl: './campaign-details.component.html',
  styleUrls: ['./campaign-details.component.css']
})
export class CampaignDetailsComponent implements OnInit {

  @Input() viewMode: string;

  @Input() inputCampaignDetails: CampaignJson;

  errorMessage:string ; 
  showCreateFeedback:string;
  
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
    
    /*
     * Reset error messages if any 
     */
    
      this.errorMessage=null;
    
    
    // Check for all information like campaign, requester, brands & others.
    // when true submit button will be enabled

    if (this.campaignDetails && this.requesterDetails && this.isNoErrorInSpecialValidations()) {
      this.finalFormValidStatus = true;
    } else {
      this.finalFormValidStatus = false;
    }
  }


  logCompleteInformation() {
    console.log('campaignDetails->'+this.campaignDetails);
    console.log('requesterDetails->'+this.requesterDetails);
  }
  
  isNoErrorInSpecialValidations() : boolean {
    /*
     * Implement Date Validations for Start and End Date
     */

    
    if(!this.validateStartDateEndDate(this.campaignDetails.startDate , this.campaignDetails.endDate))
      {
      console.log('Date validation failed for stDate : '  + this.campaignDetails.startDate + 'edDate : '+ this.campaignDetails.endDate );
      return false;
      }
     
    /*
     * Check for campaign name already exists in the system.
     */
    
      console.log('campaign name : ' + this.campaignDetails.name);
    
    
    
    
    return true;
  }
  
  validateStartDateEndDate(stDate:string, edDate:string){
    
     const today = new Date();
    
    
    if(stDate.trim().length!=10 || edDate.trim().length!=10){
      this.errorMessage='Invalid date selection. Start date or End date cannot be blank.';
      return false;
    }
    
  const stDtStr: string[] = stDate.split('/');
  const stDateDt = new Date(parseInt(stDtStr[2]), (parseInt(stDtStr[0]) - 1), parseInt(stDtStr[1]));
 
 
 const edDateStr: string[] = edDate.split('/');
  const edDateDt = new Date(parseInt(edDateStr[2]), (parseInt(edDateStr[0]) - 1), parseInt(edDateStr[1]));
 
 
 if(stDateDt<today || edDateDt<today){
   
        this.errorMessage='Invalid date selection. Start date or End date should be future date.';
   return false;
 }
 
 if(edDateDt<=stDateDt){
   this.errorMessage='Invalid date selection. End date should be after start date.';
   return false;
 }
 return true;
     
  }  
  
  
  createCampaign() {
    
    
    /*
     * Reset error and feedback messages;
     */
    this.errorMessage= null;
    this.showCreateFeedback = null;
    

    /*
     * TO-DO - Convert Start and End date to Serve side format yyyy/MMM/dd  - Eg (2017/Aug/14)
     */

    const newCampaignRecord: CampaignJson = {
      name: this.campaignDetails.name,
      stauts: this.campaignDetails.stauts,
      desc: this.campaignDetails.desc,
      startDate: '12/12/3030',
      endDate: '12/12/3030',
      estimatedRevenue: this.campaignDetails.estimatedRevenue,
      anyUpdateRequired: this.campaignDetails.anyUpdateRequired,
      regionalDirector: this.campaignDetails.regionalDirector,
      specialInstructions: this.campaignDetails.specialInstructions,
      vendorExists: this.campaignDetails.vendorExists,
      requester: this.requesterDetails
    }


    this.craService.create(newCampaignRecord).subscribe(this.campaignResponse, err => {
      console.log('Something went wrong!' + err);
      this.errorMessage="Create operation failed. Service unavailable.";
    });
    
    
  }


  campaignResponse(data: string) {
    console.log('New Record Created location : ' + data);
    this.showCreateFeedback = data;
     this.errorMessage='re';
  }
}
