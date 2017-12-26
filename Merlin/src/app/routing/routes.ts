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
       path: 'home', 
       component: HomeComponent
    },
    {
      path: 'threads',
      component: ThreadsComponent
    },
    
    // Default screen is ThreadsComponent
    {
       path: '**',
       component: HomeComponent
    }
];

