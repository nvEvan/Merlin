import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpModule, JsonpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ProfileComponent } from './components/profile/profile.component';
import { RegisterComponent } from './components/register/register.component';
import { SignInComponent } from './components/sign-in/sign-in.component';
import { HomeComponent } from './components/home/home.component';
import { NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { BadgesComponent } from './components/badges/badges.component';
import { GetUserService } from './components/services/get-user.service';
import { LoginService } from './components/services/login.service';
import { UserPrivateInfoService } from './components/services/user-private-info.service';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ProfileComponent,
    RegisterComponent,
    SignInComponent,
    HomeComponent,
    BadgesComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    JsonpModule,
    NgbModule.forRoot(),
    RouterModule.forRoot([
      {path: '', component: HomeComponent},
      {path: 'sign-in', component: SignInComponent},
      {path: 'register', component: RegisterComponent},
      {path: 'profile', component: ProfileComponent},
      {path: 'home', component: HomeComponent},
      {path: 'badges', component: BadgesComponent}
    ])
  ],
  providers: [GetUserService, LoginService, UserPrivateInfoService],
  bootstrap: [AppComponent]
})
export class AppModule {
  // constructor(private username:string){}

  // setUser(username: string){
  //   this.username = username;
  // }
}
