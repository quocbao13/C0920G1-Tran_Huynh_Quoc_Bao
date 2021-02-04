import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ChangeFont-size';
  fontSize = 14;
  onChange(value) {
    console.log(value);
    this.fontSize = value;
  }
}
