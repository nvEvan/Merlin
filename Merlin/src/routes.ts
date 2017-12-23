import { Routes } from '@angular/router';
import { RegisterComponent } from './app/components/register/register.component';
import { ProfileComponent } from './app/components/profile/profile.component';
import { HomeComponent } from './app/components/home/home.component';

export const appRoute: Routes =  [
    {path: 'register', component: RegisterComponent},
    {path: 'profile', component: ProfileComponent},
    {path: 'home', component: HomeComponent}
];
