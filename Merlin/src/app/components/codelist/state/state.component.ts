import { Component } from "@angular/core";
import { CodeListService } from "../../../services/codelist/codelist.service";
import { CodeList } from "../../../models/code-list.model";
import { OnInit } from "@angular/core/src/metadata/lifecycle_hooks";
import { Observable } from "rxjs/Observable";

@Component({
    selector: 'app-state',
    templateUrl: './state.component.html'
})

/**
 * State component that will hold the possible states for user registration.
 */
export class StateComponent implements OnInit {
    states: CodeList[]
    loading : boolean = true;

    constructor(private codeListService : CodeListService) { }

    ngOnInit() : void {        
        this.codeListService.getCodeListsByCode("US-STATE")
        .subscribe(response => {
          this.states = response;
          this.loading = false;
        })
    }
}