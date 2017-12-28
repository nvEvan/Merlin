//ngFor tutorial: https://blog.angular-university.io/angular-2-ngfor/

import { Component } from '@angular/core'; 
import { Http, Response } from '@angular/http';

@Component({
    selector:'app-search-adepts',
    template: `
    <table>
        <thead>
            <th>Name</th>
            <th>Index</th>
        </thead>
        <tbody>
            <tr *ngFor="let hero of heroes">
                <td>{{hero.name}}</td>
            </tr>
        </tbody>
    </table>
`
    // templateUrl: './search-adepts.component.html', 
    // styleUrls: ['./search-adepts.component.css']
})

export class SearchAdeptsComponent {
    HEROES = [
        {id: 1, name:'Superman'},
        {id: 2, name:'Batman'},
        {id: 5, name:'BatGirl'},
        {id: 3, name:'Robin'},
        {id: 4, name:'Flash'}
    ];
    heroes = this.HEROES;
    constructor(private http: Http){};

    doSomething() {
        this.http.get("http://localhost:8080/merlinserver/rest/fetch/adepts/all")
        .subscribe(
            (res: Response) => {
                const Adepts = res.json();
                console.log(Adepts);
            }
        )
    };
}