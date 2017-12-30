import { Injectable } from "@angular/core";
import { Http } from "@angular/http";
import { CodeList } from "../../models/code-list.model";
import { Observable } from "rxjs/Observable";
import { Response } from "@angular/http/src/static_response";

/**
 * Service class that retrieves codelists from the server
 */
@Injectable()
export class CodeListService {

    constructor(private http : Http) {}

    //get all codelists by a code
    getCodeListsByCode(code : string) : Observable<CodeList[]> {
        let url : string = 'http://localhost:8085/merlinserver/rest/codelist/getcodelist/' + code

        return this.http.get(url).map((response: Response)=> response.json());
    }
}