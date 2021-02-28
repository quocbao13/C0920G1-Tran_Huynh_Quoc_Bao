import {Component, NgModule} from '@angular/core';
import {TimelinesComponent} from './timelines/timelines.component';
import {BrowserModule} from '@angular/platform-browser';
import {AppRoutingModule} from './app-routing.module';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'time-line';
}
