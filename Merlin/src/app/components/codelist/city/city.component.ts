import { Component } from "@angular/core";
import { CodeListService } from "../../../services/codelist/codelist.service";

@Component({
    selector: 'app-citylist',
    templateUrl: './city.component.html'
})

/**
 * City component that will hold the possible states for user registration.
 */
export class CityComponent {
    constructor(private codeListService : CodeListService) { }

    /*
    getStateCodeLists() {
        return this.codeListService.getCodeListsByCode("CITY-CODE");
    }
    */
}