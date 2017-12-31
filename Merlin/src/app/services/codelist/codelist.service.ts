import { Injectable } from "@angular/core";
import { Http } from "@angular/http";
import { CodeList } from "../../models/code-list.model";
import { Observable } from "rxjs/Observable";
import { Response } from "@angular/http/src/static_response";
import { environment } from '../../../environments/environment'

/**
 * Service class that retrieves codelists from the server
 */
@Injectable()
export class CodeListService {

    constructor(private http: Http) { }

    //get all codelists by a code
    getCodeListsByCode(code: string): Observable<CodeList[]> {
        let url: string = environment.url + "merlinserver/rest/codelist/getcodelist/" + code

        return this.http.get(url).map((response: Response) => response.json());
    }

    //get the stateCity codelist from this state/city combination
    getStateCityCode(stateValue: string, cityValue: string): Observable<CodeList> {
        let url: string = environment.url + "merlinserver/rest/codelist/getstatecitycode/" + stateValue + "/" + cityValue;

        return this.http.get(url).map((response : Response) => response.json())
    }
}