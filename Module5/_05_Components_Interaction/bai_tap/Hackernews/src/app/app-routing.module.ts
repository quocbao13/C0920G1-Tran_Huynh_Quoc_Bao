import { NgModule } from '@angular/core';
import {FirstPageComponent} from './first-page/first-page.component';
import { RouterModule, Routes } from '@angular/router';
import {ShowListComponent} from './show-list/show-list.component';

const routes: Routes = [
  { path: 'firstPage', component: FirstPageComponent },
  { path: '', component: ShowListComponent }
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
