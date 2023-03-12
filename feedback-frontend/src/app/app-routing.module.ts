import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddFeedbackComponent } from './add-feedback/add-feedback.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { FeedbackFileUploadComponent } from './feedback-file-upload/feedback-file-upload.component';
import { FeedbackListComponent } from './feedback-list/feedback-list.component';
import { LoginSucessComponent } from './login-sucess/login-sucess.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { UploadFeedbackComponent } from './upload-feedback/upload-feedback.component';

const routes: Routes = [

  {
    path: '',
    component: LoginComponent
  },

  {
    path: 'AfterSucessLogin',
    component: LoginSucessComponent
  },

  {
    path: 'ForNewRegistration',
    component: SignupComponent
  },
  {
    path: 'upload-feedback',
    component: UploadFeedbackComponent
  },
  

  
  {
    path:'dashboard',
    component:DashboardComponent
  },
  {
    path:'feedback-list',
    component:FeedbackListComponent
  },
  {
    path:'add-feedback',
    component: AddFeedbackComponent
  },
  

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
