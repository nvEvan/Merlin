/**
 * @description Defines place for users to interact over the web through a form
 * @author Antony Lulciuc
 */
import { Component } from '@angular/core';
import { ChatService } from '../../services/firebase/chat/chat.service';
import { ChatMessage } from '../../models/chat-message.model';
import { IMThread } from '../../models/im-thread.model';
import { UserData } from '../../models/composite/user-data.composite';
import { LoginService } from '../../services/login/login.service';
import { Router, ActivatedRoute } from '@angular/router';
import { OnInit } from '@angular/core';
import { AfterViewInit } from '@angular/core/src/metadata/lifecycle_hooks';

@Component({
    selector: 'app-chatroom',
    templateUrl: './chatroom.component.html',
    styleUrls: ['./chatroom.component.css']
})

export class ChatRoom implements OnInit, AfterViewInit {
    messages: ChatMessage[];
    message: string;
    userData: UserData;
    link: string;
    name: string;

    constructor(private chat: ChatService, private login: LoginService, private router: Router, private route: ActivatedRoute) {
        // do nothing
    }

    /**
     * Used to initialize values and acquire query string params from url for messaging purposes 
     */
    ngOnInit() {
        var self = this;

        // Init. data
        this.messages = new Array<ChatMessage>();
        this.userData = this.login.getUserData();

        // get query params
        this.route.queryParams.subscribe(params => {
            self.link = params.link;
            self.name = params.name;

            // Load firebase data
            self.loadMessages();
        });
    }

    /**
     * Trigger resize event when screen ready
     */
    ngAfterViewInit() {
        window.dispatchEvent(new Event('resize'));
    }

    ///
    //  INIT METHODS
    ///

    /**
     * Load messages of thread from FireBase database
     */
    loadMessages() {
        var self = this;

        this.messages = new Array<ChatMessage>();

        // Use service to pull data
        this.chat.getMessages(this.link).subscribe(data => {
            self.messages = data;
        }, error => {
            debugger;
        })
    }

    ///
    //  EVENT HANDLERS 
    ///

    /**
     * Submits user message to Firebase database
     */
    onSubmit() {
        var imthread = new IMThread();
    
        debugger;
    
        // Build Message
        imthread.link= this.link;
        imthread.name= this.name;
        imthread.creator = this.userData.user;
    
        // Send message
        this.chat.sendMessage(imthread, this.userData,  this.message);

        // Force clean
        this.onClear();
      }

      /**
       * Removes/Clears user message typeed in textarea
       */
      onClear() {
          this.message = "";
      }

      /**
       * Resizes window when resize event fired
       * @param event window
       * @param form handle to form for messages
       */
      onResize(event, form) {
          var target = event.target;
          var height = target.innerHeight - 250;
          
          form.style.height = height + "px";
      }
}
