import {RequesterInformation} from './requesterinformation';

export interface CampaignJson {
  id?: number;
  name: string;
  stauts: string;
  desc: string;
  startDate: string;
  endDate: string;
  estimatedRevenue: string;
  anyUpdateRequired: string;
  regionalDirector: string;
  specialInstructions: string;
  vendorExists: string;

  requester: RequesterInformation;
}