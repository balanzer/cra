import {CampaignDetails} from '../../domain/campaigndetails';
import {ApiService} from '../api/api.service';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';


@Injectable()
export class CRAAppService {
  constructor(private service: ApiService) {

  }
  getAll(): Observable<CampaignDetails[]> {
    return this.service.get('cra');
  }

  create(data: CampaignDetails) {
    return this.service.post('cra', data);
  }

}
