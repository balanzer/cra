import {AppCommonModule} from '../app-common/app-common.module';
import {CRAAppService} from '../http-service/services/cra/craapp.service';
import {CampaignInformationComponent} from './campaign-information/campaign-information.component';
import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ManageCampaignComponent} from './manage-campaign/manage-campaign.component';
import {ReactiveFormsModule, FormsModule} from '@angular/forms';
import {Routes, RouterModule} from '@angular/router';
import {RequesterInformationComponent} from './requester-information/requester-information.component';
import {ViewCampaignComponent} from './view-campaign/view-campaign.component';
import {CreateCampaignComponent} from './create-campaign/create-campaign.component';
import {CampaignDetailsComponent} from './campaign-details/campaign-details.component';

const manageRoutes: Routes = [
  {path: 'create', component: CreateCampaignComponent},
  {path: 'view/:campaignId', component: ViewCampaignComponent},
  {path: 'manage/:campaignId', component: ManageCampaignComponent}
];


@NgModule({
  imports: [
    CommonModule, AppCommonModule, RouterModule.forChild(manageRoutes),
    FormsModule, ReactiveFormsModule
  ],
  declarations: [
    ManageCampaignComponent,
    CampaignInformationComponent,
    RequesterInformationComponent,
    ViewCampaignComponent,
    CreateCampaignComponent,
    CampaignDetailsComponent
  ],
  exports: []
})
export class ManageModule {

}
