import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomepageComponent } from './home/homepage/homepage.component';
import { LoginComponent } from './login/login.component';
import { LoginSuccessComponent } from './login-success/login-success.component';
import { SignupComponent } from './signup/signup.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';
import { CreateemployeeComponent } from './createemployee/createemployee.component';
import { EmployeelistComponent } from './employeelist/employeelist.component';
import { OnboardComponent } from './onboard/onboard.component';
import { UpdateemployeeComponent } from './updateemployee/updateemployee.component';
import { DeleteemployeeComponent } from './deleteemployee/deleteemployee.component';
import { EmployeedetailsComponent } from './employeedetails/employeedetails.component';


@NgModule({
  declarations: [
    AppComponent,
    HomepageComponent,
    LoginComponent,
    LoginSuccessComponent,
    SignupComponent,
    CreateemployeeComponent,
    EmployeelistComponent,
    OnboardComponent,
    UpdateemployeeComponent,
    DeleteemployeeComponent,
    EmployeedetailsComponent,
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatToolbarModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
