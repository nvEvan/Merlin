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
    

    constructor(private codeListService : CodeListService) { }

    ngOnInit() : void {        
       
    }
}