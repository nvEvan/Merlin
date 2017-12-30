import { Component, OnInit } from '@angular/core';
import { AdeptIdService } from '../../services/adept-id/adept-id.service';


@Component({
  selector: 'app-adept-public-profile',
  templateUrl: './adept-public-profile.component.html',
  styleUrls: ['./adept-public-profile.component.css'],
  inputs: ['Adept']
})
export class AdeptPublicProfileComponent implements OnInit {
  adeptID : number; 
  message : string;

  constructor(private adeptId_service : AdeptIdService ) { }

  ngOnInit() {
    this.adeptId_service.currentMessage.subscribe(message => this.message = message)
    console.log("The Adept ID: " + this.message);
  }
}
