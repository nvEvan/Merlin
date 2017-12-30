//ngFor tutorial: https://blog.angular-university.io/angular-2-ngfor/

import { Component } from '@angular/core'; 
import { Http, Response } from '@angular/http';
import { Router } from '@angular/router';
import { AdeptIdService } from '../../services/adept-id/adept-id.service';
import { OnInit } from '@angular/core/src/metadata/lifecycle_hooks';

@Component({
    selector:'app-search-adepts',
    templateUrl: './search-adepts.component.html', 
    styleUrls: ['./search-adepts.component.css']
})

export class SearchAdeptsComponent implements OnInit{
    Adepts : any;
    adeptId : number; 
    message : string;
    
    constructor(private http: Http, private router: Router, private adeptIdService : AdeptIdService){
        this.http.get("http://localhost:8085/merlinserver/rest/fetch/adepts/all")
        .subscribe(
            (res: Response) => {
                console.log("Fetching Adepts");
                this.Adepts = res.json();
                console.log(this.Adepts);
            }
        )
    };

    navigateToAdeptPublicProfile() {
        console.log("Navigating to an adept profile!");
        this.router.navigate(['adept-public-profile']);
      };

    navigateToHomePage() {
    console.log("Navigating to current user profile");
    this.router.navigate(['profile']);
    };

    ngOnInit() {
        this.adeptIdService.currentMessage.subscribe(message => this.message = message)
        this.adeptIdService.adeptId.subscribe(adeptID => this.adeptId = adeptID)
        console.log("#1: " + this.message);
        this.adeptIdService.changeMessage("Changing the message!!! In SearchAdeptsComponent");
        this.adeptIdService.changeId(-58);
        console.log("#2: " + this.message);
        console.log("#3: A number -> " + this.adeptId);
    }
}