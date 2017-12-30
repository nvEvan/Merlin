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
import { SearchAdeptsComponent } from '../components/search-adepts/search-adepts.component';
import { AdeptPublicProfileComponent } from '../components/adept-public-profile/adept-public-profile.component';

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
       component: SignInComponent
    },
    {
      path: 'threads',
      component: ThreadsComponent
    },
    {
      path: 'search-adepts',
      component: SearchAdeptsComponent
    },
    {
      path: 'adept-public-profile',
      component: AdeptPublicProfileComponent
    },
    
    // Default screen is ThreadsComponent
    {
       path: '**',
       component: SignInComponent
    }
];

