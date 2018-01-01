/**
 * @author: Antony Lulciuc
 * @description Populates screen with open threads for user. Allows the creation and search of threads for user to 
 * use.
 */

import { Component, ViewEncapsulation, ViewContainerRef, ComponentFactoryResolver, AfterViewInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from "../../../environments/environment";
import { shared } from "../../../shared/shared";
import { IMThread } from '../../models/im-thread.model';
import { UserData } from '../../models/composite/user-data.composite';
import { LoginService } from '../../services/login/login.service';
import { FailNewThreadModal } from '../modals/threads/failnewthread.modal';
import { IMThreadParams } from '../../models/composite/threads/imthread.composite';
import { Router } from '@angular/router';

@Component({
  selector: 'app-threads',
  templateUrl: './threads.component.html',
  encapsulation: ViewEncapsulation.None,
  styleUrls: ['./threads.component.css']
})

export class ThreadsComponent implements AfterViewInit {
  failModal: FailNewThreadModal;
  listReady: boolean;
  threads: IMThread[];
  response: IMThread[];
  userData: UserData;
  threadName: string;
  
  // Pull IM-Threads for user to interact with 
  constructor(private login: LoginService, private http: HttpClient, private viewContainerRef: ViewContainerRef, 
      private componentFactoryResolver: ComponentFactoryResolver, private router: Router) {
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
   * Trigger resize event when screen ready
   */
  ngAfterViewInit() {
      window.dispatchEvent(new Event('resize'));
  }

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

  /**
   * Injects a FailNewThreadModal  so we have access to component methods
   */
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

  /**
   * Handles new thread event
   */
  onNewThread() {
    var self = this;
    var thread = new IMThread();
    var params = new IMThreadParams();

    // Set thread information
    thread.creator = this.userData.user;
    thread.link = "message_" + this.threadName;
    thread.name = this.threadName;

    // Build request params 
    params.thread = thread;
    params.token = this.userData.token;

    // Attempt to create new thread
    this.http.post(environment.url + "merlinserver/rest/threads/insert", params).subscribe(
      data => {
        // If falsey then failed to create new thread
        if (!data)
          this.failModal.openModal();
        else
          self.loadAllThreads();
      },
      error => {
        console.log(error);
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

  // Opens selected thread
  onOpenThread(link, name) {
    this.router.navigate(['chatroom'], { queryParams: { link: link, name: name }});
  }

  /**
   * Resizes window
   * @param event window
   * @param threads thread topics container
   */
  onResize(event, threadContainer) {
    var target = event.target;
    var height = target.innerHeight - 100;
    
    threadContainer.style.height = height + "px";
  }

  ///
  //  HELPER METHODS
  ///
 
}

