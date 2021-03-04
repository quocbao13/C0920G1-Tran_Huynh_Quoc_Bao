import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {BankingComponent} from './banking/banking.component';
import {CreateComponent} from './banking/create/create.component';
import {EditComponent} from './banking/edit/edit.component';


const routes: Routes = [
  {path: 'banking', component: BankingComponent},
  {path: 'banking/create', component: CreateComponent},
  {path: 'banking/edit/:id', component: EditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
