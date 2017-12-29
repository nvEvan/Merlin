//ngFor tutorial: https://blog.angular-university.io/angular-2-ngfor/

import { Component } from '@angular/core'; 
import { Http, Response } from '@angular/http';

@Component({
    selector:'app-search-adepts',
    templateUrl: './search-adepts.component.html', 
    styleUrls: ['./search-adepts.component.css']
})

export class SearchAdeptsComponent {
    heroes : any;
    Adepts : any;
    
    HEROES = [
        {id: 1, name:'Superman'},
        {id: 2, name:'Batman'},
        {id: 5, name:'BatGirl'},
        {id: 3, name:'Robin'},
        {id: 4, name:'Flash'}
    ];
    
    constructor(private http: Http){
        this.http.get("http://localhost:8080/merlinserver/rest/fetch/adepts/all")
        .subscribe(
            (res: Response) => {
                console.log(res);
                console.log("after res._body")
                const Adepts = res.json;
                // this.Adepts = res.json;
                
                this.heroes = this.HEROES;
                console.log(typeof(this.Adepts))
                console.log(this.Adepts);
                console.log(this.heroes);
            }
        )
    };

    // doSomething() {
    //     this.http.get("http://localhost:8080/merlinserver/rest/fetch/adepts/all")
    //     .subscribe(
    //         (res: Response) => {
    //             const Adepts = res.json();
    //             console.log(Adepts);
    //         }
    //     )
    // };
}