import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';

@Injectable()
export class AdeptIdService {
  private messageSource = new BehaviorSubject<string>("This is my default message for AdeptIdService");
  currentMessage = this.messageSource.asObservable();

  private adeptIdSource = new BehaviorSubject<number>(-42); //A placeholder number
  adeptId = this.adeptIdSource.asObservable();

  constructor() { }
  changeMessage(message: string) {
    this.messageSource.next(message)
  }

  changeId(newId: number) {
    this.adeptIdSource.next(newId);
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
