//ngFor tutorial: https://blog.angular-university.io/angular-2-ngfor/

import { Component } from '@angular/core'; 
import { Http, Response } from '@angular/http';
import { Router } from '@angular/router';

@Component({
    selector:'app-search-adepts',
    templateUrl: './search-adepts.component.html', 
    styleUrls: ['./search-adepts.component.css']
})

export class SearchAdeptsComponent {
    Adepts : any;
    
    constructor(private http: Http, private router: Router){
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
}