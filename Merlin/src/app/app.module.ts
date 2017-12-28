///
//  ANGULAR MODULES
///

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpModule, JsonpModule } from '@angular/http';

///
//  DEPENDENDICES
///

import { NgbModule} from '@ng-bootstrap/ng-bootstrap';

///
//  ROUTING
///

import { appRoute } from './routing/routes';

///
//  COMPONENTS
///

import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ProfileComponent } from './components/profile/profile.component';
import { RegisterComponent } from './components/register/register.component';
import { SignInComponent } from './components/sign-in/sign-in.component';
import { HomeComponent } from './components/home/home.component';
import { BadgesComponent } from './components/badges/badges.component';
import { ThreadsComponent } from './components/threads/threads.component';
import { SearchAdeptsComponent } from './components/search-adepts/search-adepts.component';

///
//  SERVICES
///

import { GetUserService } from './services/get-user/get-user.service';
import { LoginService } from './services/login/login.service';
import { UserPrivateInfoService } from './services/user-private-info/user-private-info.service';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ProfileComponent,
    RegisterComponent,
    SignInComponent,
    HomeComponent,
    BadgesComponent,
    ThreadsComponent,
    SearchAdeptsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    JsonpModule,
    NgbModule.forRoot(),
    RouterModule.forRoot(appRoute)
  ],
  providers: [GetUserService, LoginService, UserPrivateInfoService],
  bootstrap: [AppComponent]
})
  
export class AppModule {
}
