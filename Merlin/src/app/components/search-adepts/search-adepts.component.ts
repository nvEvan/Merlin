//ngFor tutorial: https://blog.angular-university.io/angular-2-ngfor/

import { Component } from '@angular/core'; 
import { Http, Response } from '@angular/http';

@Component({
    selector:'app-search-adepts',
    templateUrl: './search-adepts.component.html', 
    styleUrls: ['./search-adepts.component.css']
})

export class SearchAdeptsComponent {
    Adepts : any;
    
    constructor(private http: Http){
        this.http.get("http://localhost:8085/merlinserver/rest/fetch/adepts/testuser")
        .subscribe(
            (res: Response) => {
                console.log("Fetching Adepts");
                this.Adepts = res.json();
                console.log(this.Adepts);
            }
        )
    };
}