import {AppCommonModule} from '../app-common/app-common.module';
import {CRAAppService} from './services/cra/craapp.service';
import {ApiService} from './services/api/api.service';
import {NgModule, APP_BOOTSTRAP_LISTENER} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HttpModule} from '@angular/http';

@NgModule({
  imports: [
    CommonModule, AppCommonModule, HttpModule
  ],
  exports: [],
  providers: [ApiService, CRAAppService],
  declarations: []
})
export class HttpServiceModule {}
