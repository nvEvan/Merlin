/**
 * @author: Antony
 * @description Populates screen with open threads for user
 */

import { Component, ViewEncapsulation, ViewContainerRef, ComponentFactoryResolver } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from "../../../environments/environment";
import { shared } from "../../../shared/shared";
import { IMThread } from '../../models/im-thread.model';
import { ChatService } from '../../services/firebase/chat/chat.service';
import { PrivateUserInfo } from '../../models/private-user-info.model';
import { UserData } from '../../models/composite/user-data.composite';
import { LoginService } from '../../services/login/login.service';
import { FailNewThreadModal } from '../modals/threads/failnewthread.modal';
import { IMThreadParams } from '../../models/composite/threads/imthread.composite';

@Component({
  selector: 'app-threads',
  templateUrl: './threads.component.html',
  encapsulation: ViewEncapsulation.None,
  styleUrls: ['./threads.component.css']
})

export class ThreadsComponent  {
  failModal: FailNewThreadModal;
  listReady: boolean;
  threads: IMThread[];
  response: IMThread[];
  userData: UserData;
  threadName: string;
  
  // Pull IM-Threads for user to interact with 
  constructor(private login: LoginService, private http: HttpClient, private chat: ChatService,
      private viewContainerRef: ViewContainerRef, private componentFactoryResolver: ComponentFactoryResolver) {
    this.userData = this.login.getUserData();
    
    // Add modal
    this.injectModal();

    // update threads 
    this.loadAllThreads();
  }

  ///
  //  INIT METHODS
  ///

  /**
   * Load All thread groups from server
   */
  loadAllThreads() {
    var self = this;
    
    // Initialize 
    this.listReady = false;
    this.threads = new Array<IMThread>();

    this.http.get(environment.url + "merlinserver/rest/threads/get/all/").subscribe(data => {
      // Received content 
      self.listReady = true;

      // If we have data 
      if (data) {
        self.response = <Array<any>>data;
        
        // Create list to show to user
        for (let item of self.response)
          self.threads.push(<IMThread>item);
      }
    });
  }

  injectModal() {
    const componentFactory = this.componentFactoryResolver.resolveComponentFactory(FailNewThreadModal);
    const containerRef = this.viewContainerRef;

    // Remove previous gens.
    containerRef.clear();

    // Inject component
    this.failModal = containerRef.createComponent(componentFactory).instance;
  }

  ///
  //  EVENT HANDLERS
  ///

  onNewThread() {
    var self = this;
    var thread = new IMThread();
    var params = new IMThreadParams();

    thread.creator = this.userData.user;
    thread.link = "message_" + this.threadName;
    thread.name = this.threadName;

    params.thread = thread;
    params.token = this.userData.token;

    this.http.post(environment.url + "merlinserver/rest/threads/insert", params).subscribe(
      data => {
        if (!data)
          this.failModal.openModal();
        else
          self.loadAllThreads();
      },
      error => {
        debugger;
      }
    );
  }

  /**
   * Updates list shown to user via thread name
   */
  onSearchThread() {
    var thread: IMThread;

    // clear list 
    this.threads = new Array<IMThread>();

    // go through response and build list filtering by thread name
    for (let item of this.response) {
      thread = <IMThread>item;

      if (thread.name.match(this.threadName + "(.*?)"))
        this.threads.push(thread);
    }
  }

  onSubmit() {
    var imthread = new IMThread();

    debugger;

    imthread.link="message_" + this.threadName;
    imthread.name= this.threadName;
    imthread.creator = this.userData.user;

    this.chat.sendMessage(imthread, this.userData, "this is a test");
  }


  ///
  //  HELPER METHODS
  ///
 
}

