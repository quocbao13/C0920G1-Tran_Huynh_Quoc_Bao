import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { LikesComponent } from './likes/likes.component';
import { MenuComponent } from './menu/menu.component';
import { RouterModule, Routes } from '@angular/router';
import { FooterComponent } from './footer/footer.component';
import { FirstPageComponent } from './first-page/first-page.component';
import { AppRoutingModule } from './app-routing.module';
import { ShowInfoComponent } from './show-info/show-info.component';
import { ShowListComponent } from './show-list/show-list.component';
import { ShowCreateComponent } from './show-create/show-create.component';

const routes: Routes = [
  { path: 'firstPage', component: FirstPageComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    LikesComponent,
    MenuComponent,
    FooterComponent,
    FirstPageComponent,
    ShowInfoComponent,
    ShowListComponent,
    ShowCreateComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
