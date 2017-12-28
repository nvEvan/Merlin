/**
 * @author Antony Lulicuc
 * @description defines base for instant mesaging feature for Merlin WebApp.
 */
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';

///
//  FIREBASE
///

import { AngularFireDatabase, AngularFireList } from 'angularfire2/database';
import { AngularFireAuth } from 'angularfire2/auth';

import * as firebase from 'firebase/app';

///
//  SERVICES
///

import { AuthService } from '../authenticate/auth.service';

///
//  MODELS
///

import { ChatMessage } from '../../../models/chat-message.model';
import { PrivateUserInfo } from '../../../models/private-user-info.model';
import { IMThread } from '../../../models/im-thread.model';
import { UserData } from '../../../models/composite/user-data.composite';

@Injectable()
export class ChatService {
  user: any;
  chatMessages: AngularFireList<ChatMessage>;
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
   * @param imthread - used to tie message to thread 
   * @param info - User information
   * @param msg - message they wish to send
   */
  sendMessage(imthread: IMThread, info: UserData, msg: string){
    const timestamp = this.getTimeStamp();

    // Get lastest messages for DB
    this.chatMessages = this.getMessages(imthread);

    // Create new message and broadcast to users
    this.chatMessages.push(new ChatMessage(info, msg));
  }

  /**
   * @description Acquires thread data from Firebase database 
   * @param imthread - used to tie message to thread 
   * @returns List of messages 
   */
  getMessages(imthread: IMThread): AngularFireList<ChatMessage>{
    return this.db.list(imthread.link);
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
