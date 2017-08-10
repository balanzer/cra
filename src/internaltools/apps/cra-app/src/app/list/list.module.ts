import {AppCommonModule} from '../app-common/app-common.module';
import {HttpServiceModule} from '../http-service/http-service.module';
import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ListRecordsComponent} from './list-records/list-records.component';
import {RouterModule, Routes} from '@angular/router';


const listRoutes: Routes = [
  {path: 'list', component: ListRecordsComponent}
];

@NgModule({
  imports: [
    CommonModule,
    AppCommonModule,
    HttpServiceModule,
    RouterModule.forChild(listRoutes)
  ],
  declarations: [ListRecordsComponent],
  exports: [ListRecordsComponent],

})
export class ListModule {}
