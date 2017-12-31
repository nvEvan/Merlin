///
//  ANGULAR MODULES
///

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpModule, JsonpModule } from '@angular/http';
import { HttpClientModule } from '@angular/common/http';
///
//  DEPENDENDICES
///

import { NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { AngularFireModule } from 'angularfire2';
import { AngularFireDatabaseModule } from 'angularfire2/database-deprecated';
import { AngularFireAuthModule, AngularFireAuth } from 'angularfire2/auth';
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { TooltipModule } from 'ngx-bootstrap/tooltip';
import { ModalModule } from 'ngx-bootstrap/modal';

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
import { StateComponent } from './components/codelist/state/state.component'
import { CityComponent } from './components/codelist/city/city.component';
import { ChatRoom } from './components/chatroom/chatroom.component';

///
//  DIRECTIVES
///

import { DropdownDirective } from './directives/dropdown/dropdown.directive';

///
//  SERVICES
///

import { GetUserService } from './services/get-user/get-user.service';
import { LoginService } from './services/login/login.service';
import { UserPrivateInfoService } from './services/user-private-info/user-private-info.service';
import { ChatService } from './services/firebase/chat/chat.service';
import { AuthService } from './services/firebase/authenticate/auth.service';
import { SimpleNgbModal } from "./services/modals/simple.ngb.modal"
import { CodeListService } from './services/codelist/codelist.service';
import { RegistrationService } from './services/registration/registration.service';

///
//  MODALS 
///

import { FailNewThreadModal } from './components/modals/threads/failnewthread.modal'

///
//  VARIABLES
///

import { environment } from './../environments/environment'
import { VerifyAdepts } from './components/verifyAdepts/verifyAdepts.component';

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
    DropdownDirective,
    FailNewThreadModal,
    StateComponent,
    CityComponent,
    ChatRoom,
    VerifyAdepts
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    HttpModule,
    JsonpModule,
    BsDropdownModule.forRoot(),
    TooltipModule.forRoot(),
    ModalModule.forRoot(),
    AngularFireModule.initializeApp(environment.firebase),
    AngularFireAuthModule,
    AngularFireDatabaseModule,
    AngularFireModule,
    NgbModule.forRoot(),
    RouterModule.forRoot(appRoute)
  ],
  entryComponents: [
    FailNewThreadModal
  ],
  providers: [
    GetUserService, 
    LoginService,
    UserPrivateInfoService, 
    AuthService, 
    ChatService,
    CodeListService,
    RegistrationService,
    SimpleNgbModal
  ],
  bootstrap: [AppComponent]
})
  
export class AppModule {
}
