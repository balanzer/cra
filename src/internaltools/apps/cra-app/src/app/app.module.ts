import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {AppComponent} from './app.component';
import {ReactiveFormsModule, FormsModule} from '@angular/forms';
import {AppCommonModule} from './app-common/app-common.module';
import {AppRoutingModule} from './app-routing.module';
import {ListModule} from './list/list.module';
import {ManageModule} from './manage/manage.module';


@NgModule({
  imports: [
    AppCommonModule, ListModule, ManageModule, BrowserModule, FormsModule, ReactiveFormsModule, NgbModule.forRoot(),
    AppRoutingModule
  ],
  declarations: [
    AppComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
