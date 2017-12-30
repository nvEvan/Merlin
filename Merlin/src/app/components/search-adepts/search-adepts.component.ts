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
    adeptID : number; 
    message : string;
    
    constructor(private http: Http, private router: Router, private adeptId_service : AdeptIdService){
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
        this.adeptId_service.currentMessage.subscribe(message => this.message = message)
        console.log("#1: " + this.message);
        this.adeptId_service.changeMessage("Changing the message!!! In SearchAdeptsComponent");
        console.log("#2: " + this.message);
    }
}