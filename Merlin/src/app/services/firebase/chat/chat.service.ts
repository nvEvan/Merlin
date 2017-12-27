/**
 * @author Antony Lulicuc
 * @description defines base for instant mesaging feature for Merlin WebApp.
 */
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';

///
//  FIREBASE
///

import { AngularFireDatabase, FirebaseListObservable } from 'angularfire2/database-deprecated';
import { AngularFireAuth } from 'angularfire2/auth';
import * as firebase from 'firebase/app';

///
//  SERVICES
///

import { AuthService } from '../authenticate/auth.service';

///
//  MODELS
///

import { ChatMessage } from '../../../components/models/chat-message';
import { PrivateUserInfo } from '../../../components/models/private-user-info';
import { IMThread } from '../../../components/models/im-thread';

@Injectable()
export class ChatService {
  user: any;
  chatMessages: FirebaseListObservable<ChatMessage[]>;
  chatMessage: ChatMessage;
  userName: Observable<string>;

  constructor(private db: AngularFireDatabase,  private afAuth: AngularFireAuth) { 
    this.afAuth.authState.subscribe(auth => {
      if(auth != undefined && auth != null){
        this.user = auth;
      }
    });
  }

  /**
   * Sends message to thread for 
   * @param info - User information
   * @param msg - message they wish to send
   */
  sendMessage(imthread: IMThread, info: PrivateUserInfo, msg: string){
    const timestamp = this.getTimeStamp();
    
    // Get lastest messages for DB
    this.chatMessages = this.getMessages(imthread);

    // Create new message and broadcast to users
    this.chatMessages.push({
      message: msg,
      timeSent: timestamp,
      userName: info.username,
      email: info.email   
    });
  }

  /**
   * @returns List of messages 
   */
  getMessages(imthread: IMThread): FirebaseListObservable<ChatMessage[]>{
    return this.db.list(imthread.link, {
      query:{
        limitToLast: 20,
        orderByKey:true
      }
    });
  }

  /**
   * @returns current date + time
   */
  getTimeStamp(){
    const now = new Date();
    const date = now.getUTCFullYear() + '/' + (now.getUTCMonth() + 1) + '/' + now.getUTCDay();
    const time = now.getUTCHours() + ':' + now.getUTCMinutes() + ':' + now.getUTCSeconds();
    return (date + ' ' + time);
  }

}
