import { Component } from "@angular/core";
import { CodeListService } from "../../../services/codelist/codelist.service";
import { CodeList } from "../../../models/code-list.model";
import { OnInit } from "@angular/core/src/metadata/lifecycle_hooks";
import { Observable } from "rxjs/Observable";

/**
 * Component used to display options for cities in user registration.
 * @author Alex
 */
@Component({
    selector: 'app-city',
    templateUrl: './city.component.html'
})

/**
 * City component that will hold the possible states for user registration.
 */
export class CityComponent implements OnInit { 
    cities : CodeList[]

    constructor(private codeListService : CodeListService) { }
    
    ngOnInit() : void {
        this.codeListService.getCodeListsByCode("CITY-CODE") //grab the cities from the server
                .subscribe(response => {
                this.cities = response
            })
        }
}