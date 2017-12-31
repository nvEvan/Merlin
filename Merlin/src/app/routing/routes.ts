/**
 * @description Used for routing (application navigation)
 * @author Luie
 */

import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './../components/register/register.component';
import { SignInComponent } from './../components/sign-in/sign-in.component';
import { ProfileComponent } from './../components/profile/profile.component';
import { HomeComponent } from './../components/home/home.component';
import { ThreadsComponent } from './../components/threads/threads.component';
import { ChatRoom } from '../components/chatroom/chatroom.component';
import { VerifyAdepts } from '../components/verifyAdepts/verifyAdepts.component';

/**
 * Place all routes here (used for navigating our application).
 */
export const appRoute: Routes =  [
    {
      path: 'register', 
      component: RegisterComponent
    },
    {
      path: 'sign-in', 
      component: SignInComponent
    },
    {
       path: 'profile', 
       component: ProfileComponent
    },
    {
      path: 'verifyAdepts',
      component: VerifyAdepts
    },
    {
       path: 'home', 
       component: SignInComponent
    },
    {
      path: 'threads',
      component: ThreadsComponent
    },
    {
      path: 'chatroom',
      component: ChatRoom
    },
    
    // Default screen is ThreadsComponent
    {
       path: '**',
       component: SignInComponent
    }
];

