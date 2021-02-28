import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-show-create',
  templateUrl: './show-create.component.html',
  styleUrls: ['./show-create.component.css']
})
export class ShowCreateComponent implements OnInit {

  title: string;
  url: string;

  constructor() { }

  ngOnInit(): void {
  }
}
