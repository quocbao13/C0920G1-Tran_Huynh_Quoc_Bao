import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CountdownTimerComponent } from './countdown-timer/countdown-timer.component';
import { CountdownTimerAliasComponent } from './countdown-timer-alias/countdown-timer-alias.component';
import { CountdownTimerOnchangesComponent } from './countdown-timer-onchanges/countdown-timer-onchanges.component';

@NgModule({
  declarations: [
    AppComponent,
    CountdownTimerComponent,
    CountdownTimerAliasComponent,
    CountdownTimerOnchangesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
