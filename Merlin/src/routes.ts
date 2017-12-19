import { Routes } from '@angular/router';
import { RegisterComponent } from './app/register/register.component';
import { ProfileComponent } from './app/profile/profile.component';
import { HomeComponent } from './app/home/home.component';

export const appRoute: Routes =  [
    {path: 'register', component: RegisterComponent},
    {path: 'profile', component: ProfileComponent},
    {path: 'home', component: HomeComponent}
];