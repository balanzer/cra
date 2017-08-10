import {AppCommonModule} from '../app-common/app-common.module';
import {CRAAppService} from '../http-service/services/cra/craapp.service';
import {CampaignInformationComponent} from './campaign-information/campaign-information.component';
import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ManageCampaignComponent} from './manage-campaign/manage-campaign.component';
import {ReactiveFormsModule, FormsModule} from '@angular/forms';
import {Routes, RouterModule} from '@angular/router';
import {RequesterInformationComponent} from './requester-information/requester-information.component';

const manageRoutes: Routes = [
  {path: 'create', component: ManageCampaignComponent}
];


@NgModule({
  imports: [
    CommonModule, AppCommonModule, RouterModule.forChild(manageRoutes),
    FormsModule, ReactiveFormsModule
  ],
  declarations: [
    ManageCampaignComponent,
    CampaignInformationComponent,
    RequesterInformationComponent
  ],
  exports: [ManageCampaignComponent]
})
export class ManageModule {

}
