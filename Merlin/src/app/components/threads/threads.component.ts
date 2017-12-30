/**
 * @author: Antony
 * @description Populates screen with open threads for user
 */

import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from "../../../environments/environment";
import { shared } from "../../../shared/shared";
import { IMThread } from '../../models/im-thread.model';
import { ChatService } from '../../services/firebase/chat/chat.service';
import { PrivateUserInfo } from '../../models/private-user-info.model';
import { UserData } from '../../models/composite/user-data.composite';
import { LoginService } from '../../services/login/login.service';

@Component({
  selector: 'app-threads',
  templateUrl: './threads.component.html',
  styleUrls: ['./threads.component.css']
})

export class ThreadsComponent {
  threads: IMThread[];
  userData: UserData;
  msg: string;

  // Pull IM-Threads for user to interact with 
  constructor(private login: LoginService, private http: HttpClient, private chat: ChatService)  {
    this.userData = this.login.getUserData();
  }

  ///
  //  INIT METHODS
  ///

  loadAllThreads() {
    this.http.get(environment.url + "merlinserver/rest/threads/get/all/").subscribe(data => {
      this.threads.push(<IMThread>data);
    });
  }

  ///
  //  EVENT HANDLERS
  ///

  onSubmit() {
    var imthread = new IMThread();

    debugger;
    imthread.link="messagetest";
    imthread.name="test";
    imthread.creator = this.userData.general;

    this.chat.sendMessage(imthread, this.userData, "this is a test");
  }


  ///
  //  HELPER METHODS
  ///
 
}

