//ngFor tutorial: https://blog.angular-university.io/angular-2-ngfor/

import { Component } from '@angular/core'; 
import { Http, Response } from '@angular/http';
import { Router } from '@angular/router';
import { AdeptIdService } from '../../services/adept-id/adept-id.service';
import { OnInit } from '@angular/core/src/metadata/lifecycle_hooks';
import { environment } from '../../../environments/environment'

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
    
    constructor(private http: Http, private router: Router, private adeptIdService : AdeptIdService){};

    /*
    * navigateToAdeptPublicProfile - Navigates to view an adept's public profile
    * @params   Adept - JSON object containing adept information
    */
    navigateToAdeptPublicProfile(Adept) {
        this.adeptIdService.changeId(Adept.user.userId);
        this.router.navigate(['adept-public-profile']);
      };

    /*
    * navigateToHomePage - Navigates to the application's home page
    */ 
    navigateToHomePage() {
    console.log("Navigating to current user profile");
    this.router.navigate(['profile']);
    };

    ngOnInit() {
        //Fetch all adepts from the database
        this.http.get(environment.url + "merlinserver/rest/fetch/adepts/all")
        .subscribe(
            (res: Response) => {
                this.Adepts = res.json();
            }
        )

        //Store data in service
        this.adeptIdService.adeptId.subscribe(adeptID => this.adeptId = adeptID)
    }
}