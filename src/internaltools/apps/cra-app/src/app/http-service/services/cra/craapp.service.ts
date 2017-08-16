import {CampaignJson} from '../../domain/campaignJson';
import {CampaignDetails} from '../../domain/campaigndetails';
import {ApiService} from '../api/api.service';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';


@Injectable()
export class CRAAppService {
  constructor(private service: ApiService) {

  }
  getAll(): Observable<CampaignJson[]> {
    return this.service.get('cra');
  }

  getByID(id: number): Observable<CampaignJson> {
    return this.service.get(`cra/${id}`);
  }

  create(data: CampaignDetails) {
    return this.service.post('cra', data);
  }

}
