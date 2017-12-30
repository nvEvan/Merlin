import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';

@Injectable()
export class AdeptIdService {
  private messageSource = new BehaviorSubject<string>("This is my default message for AdeptIdService");
  currentMessage = this.messageSource.asObservable();
  constructor() { }
  changeMessage(message: string) {
    this.messageSource.next(message)
  }

  // adeptID : any;

  // constructor() { }

  // getAdeptId() {
  //   return this.adeptID;
  // }

  // setAdeptId(adept_id : any) {
  //   this.adeptID = adept_id;
  // }  
}
