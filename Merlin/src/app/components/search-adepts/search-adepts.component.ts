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

/*
* SearchAdeptsComponent - Functionality for searchign through adepts
* @author - Evan
*/
export class SearchAdeptsComponent implements OnInit{
    Adepts : any;
    adeptId : number; 
    message : string;
    
    constructor(private http: Http, private router: Router, private adeptIdService : AdeptIdService){};

    /*
    * navigateToAdeptPublicProfile - Navigates to view an adept's public profile
    * @params   Adept - JSON object containing adept information
    */
    navigateToAdeptPublicProfile(Adept) {
        this.adeptIdService.changeId(Adept.user.userId);
        this.router.navigate(['adept-public-profile']);
      };

    navigateToHomePage() {
    console.log("Navigating to current user profile");
    this.router.navigate(['profile']);
    };

    ngOnInit() {
        //Fetch all adepts from the database
        this.http.get("http://localhost:8085/merlinserver/rest/fetch/adepts/all")
        .subscribe(
            (res: Response) => {
                this.Adepts = res.json();
            }
        )

        this.adeptIdService.currentMessage.subscribe(message => this.message = message)
        this.adeptIdService.adeptId.subscribe(adeptID => this.adeptId = adeptID)
        this.adeptIdService.changeMessage("Changing the message!!! In SearchAdeptsComponent");
        this.adeptIdService.changeId(-58);
    }
}