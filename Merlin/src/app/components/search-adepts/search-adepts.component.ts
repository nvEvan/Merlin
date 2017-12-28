import { Component } from '@angular/core'; 
import { Http, Response } from '@angular/http';

@Component({
    selector:'app-search-adepts',
    templateUrl: './search-adepts.component.html', 
    styleUrls: ['./search-adepts.component.css']
})

export class SearchAdeptsComponent {
    constructor(private http: Http) {}

    doSomething() {
        this.http.get("http://localhost:8080/merlinserver/rest/fetch/adepts/all")
        .subscribe(
            (res: Response) => {
                const Adepts = res.json();
                console.log(Adepts);
            }
        )
    }


}