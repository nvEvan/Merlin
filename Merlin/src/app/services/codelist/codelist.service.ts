import { Injectable } from "@angular/core";
import { Http } from "@angular/http/src/http";

/**
 * Service class that retrieves codelists from the server
 */
@Injectable()
export class CodeListService {

    constructor(private http : Http) {}

    //get all codelists by a code
    getCodeListsByCode(code : string) {
        return this.http.get('http://localhost:8085/merlinserver/rest/codelist/getcodelist/' + code);
    }
}