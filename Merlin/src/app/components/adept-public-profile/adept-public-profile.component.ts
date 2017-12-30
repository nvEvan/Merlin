import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-adept-public-profile',
  templateUrl: './adept-public-profile.component.html',
  styleUrls: ['./adept-public-profile.component.css'],
  inputs: ['Adept']
})
export class AdeptPublicProfileComponent implements OnInit {
  constructor() { }

  ngOnInit() {
  }
}
