import { Component } from "@angular/core/src/metadata/directives";
import { CodeListService } from "../../../services/codelist/codelist.service";

@Component({
    selector: 'app-statelist',
    templateUrl: './state.component.html'
})

/**
 * City component that will hold the possible states for user registration.
 */
export class City {
    constructor(private codeListService : CodeListService) { }

    getStateCodeLists() {
        return this.codeListService.getCodeListsByCode("CITY-CODE");
    }
}