import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpModule, JsonpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ProfileComponent } from './profile/profile.component';
import { RegisterComponent } from './register/register.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { HomeComponent } from './home/home.component';
import { NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { BadgesComponent } from './badges/badges.component';
import { GetUserService } from './services/get-user.service';
import { LoginService } from './services/login.service';
import { UserPrivateInfoService } from './services/user-private-info.service';

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
