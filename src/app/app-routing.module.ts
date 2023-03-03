import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateemployeeComponent } from './createemployee/createemployee.component';
import { DeleteemployeeComponent } from './deleteemployee/deleteemployee.component';
import { EmployeelistComponent } from './employeelist/employeelist.component';
import { HomepageComponent } from './home/homepage/homepage.component';
import { LoginSuccessComponent } from './login-success/login-success.component';
import { LoginComponent } from './login/login.component';
import { OnboardComponent } from './onboard/onboard.component';
import { SignupComponent } from './signup/signup.component';
import { UpdateemployeeComponent } from './updateemployee/updateemployee.component';

const routes: Routes = [
 /*{ path: '',redirectTo: 'employee',  pathMatch: 'full'}, */
  { path: '',component:HomepageComponent}, 
  {path:'login',component:LoginComponent},
  {path:'signup',component:SignupComponent},
  {path:'AfterSucessLogin',component:LoginSuccessComponent},
  {path:'ForNewRegistration',component:SignupComponent},
   {path:'createemployee',component:CreateemployeeComponent},
   {path:'onboard',component:OnboardComponent},
   {path:'employeelist',component:EmployeelistComponent},
   {path:'updateemployee',component:UpdateemployeeComponent},
   {path:'deleteemplye',component:DeleteemployeeComponent}
   
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
