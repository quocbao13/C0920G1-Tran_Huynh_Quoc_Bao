import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FirstPageComponent} from './first-page/first-page.component';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: 'firstPage', component: FirstPageComponent }
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
