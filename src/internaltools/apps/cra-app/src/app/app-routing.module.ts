/**
 * Route configs for entire CRA Application.
 */

import {NgModule} from '@angular/core';
import {Routes, ExtraOptions, RouterModule} from '@angular/router';


const routes: Routes = [
  {path: '', redirectTo: 'create', pathMatch: 'full'},
  {path: 'create', loadChildren: './manage/manage.module#ManageModule'},
  {path: 'list', loadChildren: './list/list.module#ListModule'}

];

const config: ExtraOptions = {
  useHash: true,
  enableTracing: false // Turn this on to log routing events to the console
  // ,preloadingStrategy: PreloadAllModules
};


@NgModule({
  imports: [RouterModule.forRoot(routes, config)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
