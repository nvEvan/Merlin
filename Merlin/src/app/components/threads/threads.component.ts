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

@Component({
  selector: 'app-threads',
  templateUrl: './threads.component.html',
  styleUrls: ['./threads.component.css']
})

export class ThreadsComponent {
  threads = [];
  messageCount = 0;
  msg: string;

  // TODO : pull IM-Threads for user to interact with 
  constructor(private http: HttpClient, private chat: ChatService)  {
    console.log(shared.data.info);
    this.http.get(environment.url + "merlinserver/rest/threads/get/all").subscribe(data => this.threads.push(data));
  }

  onSubmit() {
    var imthread = new IMThread();
    var data = new UserData();

    debugger;
    imthread.link="messagetest";
    imthread.name="test";
    imthread.creator = shared.data.info.general;
    data.privateInfo = new PrivateUserInfo();
    data.privateInfo.email = "myemail@email.com";
    data.general = shared.data.info.general;

    this.chat.sendMessage(imthread, data, "this is a test");
    debugger;
  }
}

