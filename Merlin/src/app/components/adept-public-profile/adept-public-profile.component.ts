import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-adept-public-profile',
  templateUrl: './adept-public-profile.component.html',
  styleUrls: ['./adept-public-profile.component.css']
})
export class AdeptPublicProfileComponent implements OnInit {
  constructor() { }

  ngOnInit() {
  }

  navigateToAdeptPublicProfile() {
    console.log("Hello!");
  }
}
