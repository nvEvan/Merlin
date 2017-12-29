import { Component } from "@angular/core";
import { CodeListService } from "../../../services/codelist/codelist.service";
import { CodeList } from "../../../models/code-list.model";
import { OnInit } from "@angular/core/src/metadata/lifecycle_hooks";
import { Observable } from "rxjs/Observable";

@Component({
    selector: 'app-statelist',
    templateUrl: './state.component.html'
})

/**
 * State component that will hold the possible states for user registration.
 */
export class StateComponent implements OnInit {
    states : CodeList[]

    constructor(private codeListService : CodeListService) { }

    ngOnInit() : void {
        console.log("get states");
        /*
        this.codeListService.getCodeListsByCode("US-STATE")
        .subscribe(response => {
            console.log(response);
            this.states = response;
            console.log(this.states);
        })*/
            
    }
}