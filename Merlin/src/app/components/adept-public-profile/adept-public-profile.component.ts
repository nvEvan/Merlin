import { Component, OnInit } from '@angular/core';
import { AdeptIdService } from '../../services/adept-id/adept-id.service';
import { Http, Response } from '@angular/http';
import { environment } from '../../../environments/environment';


@Component({
  selector: 'app-adept-public-profile',
  templateUrl: './adept-public-profile.component.html',
  styleUrls: ['./adept-public-profile.component.css'],
  inputs: ['Adept']
})

//Display the public profile for an adept
export class AdeptPublicProfileComponent implements OnInit {
  Adept : any;
  adeptId : number; 

  constructor(private http: Http, private adeptIdService : AdeptIdService ) { }

  ngOnInit() {
    this.adeptIdService.adeptId.subscribe(adeptID => this.adeptId = adeptID);
    console.log("The Adept ID: " + this.adeptId);

    this.http.post(environment.url + "merlinserver/rest/fetch/adepts/byId", this.adeptId)
    .subscribe(
        (res: Response) => {
            this.Adept = res.json();
            console.log(this.Adept);
        }
    )

  }
}
