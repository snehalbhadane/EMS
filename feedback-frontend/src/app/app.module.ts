 import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { LoginSucessComponent } from './login-sucess/login-sucess.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';
import { FeedbackFileUploadComponent } from './feedback-file-upload/feedback-file-upload.component';

import { FeedbackListComponent } from './feedback-list/feedback-list.component';
import { AddFeedbackComponent } from './add-feedback/add-feedback.component';

import { DashboardComponent } from './dashboard/dashboard.component';
import { UploadFeedbackComponent } from './upload-feedback/upload-feedback.component';
import { MenuComponent } from './menu/menu.component';
import { ApiService } from './service/apiService';
import { EmployeeFeedbackService } from './service/employeeFeedbackService';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    LoginSucessComponent,
    FeedbackFileUploadComponent,
   
    FeedbackListComponent,
    AddFeedbackComponent,
 
    DashboardComponent,
      UploadFeedbackComponent,
      MenuComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatToolbarModule,
    
    
  ],
  providers: [

    ApiService,
    EmployeeFeedbackService

  ],
  bootstrap: [AppComponent,FeedbackFileUploadComponent]
})
export class AppModule { }
