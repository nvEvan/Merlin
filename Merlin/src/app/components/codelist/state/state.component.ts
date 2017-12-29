import { Component } from "@angular/core/src/metadata/directives";
import { CodeListService } from "../../../services/codelist/codelist.service";

@Component({
    selector: 'app-statelist',
    templateUrl: './state.component.html'
})

/**
 * State component that will hold the possible states for user registration.
 */
export class State {
    constructor(private codeListService : CodeListService) { }

    getStateCodeLists() {
        return this.codeListService.getCodeListsByCode("US-STATE");
    }
}