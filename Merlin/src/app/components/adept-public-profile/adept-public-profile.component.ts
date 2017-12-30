import { Component, OnInit } from '@angular/core';
import { AdeptIdService } from '../../services/adept-id/adept-id.service';


@Component({
  selector: 'app-adept-public-profile',
  templateUrl: './adept-public-profile.component.html',
  styleUrls: ['./adept-public-profile.component.css'],
  inputs: ['Adept']
})
export class AdeptPublicProfileComponent implements OnInit {
  adeptId : number; 
  message : string;

  constructor(private adeptIdService : AdeptIdService ) { }

  ngOnInit() {
    this.adeptIdService.currentMessage.subscribe(message => this.message = message);
    this.adeptIdService.adeptId.subscribe(adeptID => this.adeptId = adeptID);
    console.log("The Adept ID: " + this.adeptId);
  }
}
