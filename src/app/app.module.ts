import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomepageComponent } from './home/homepage/homepage.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';
import{MatSidenavModule}from'@angular/material/sidenav';
import{MatIconModule}from'@angular/material/icon';
import{MatListModule}from'@angular/material/list';
import { CreateemployeeComponent } from './createemployee/createemployee.component';
import { EmployeelistComponent } from './employeelist/employeelist.component';
import { OnboardComponent } from './onboard/onboard.component';
import { UpdateemployeeComponent } from './updateemployee/updateemployee.component';
import { DeleteemployeeComponent } from './deleteemployee/deleteemployee.component';
import { EmployeedetailsComponent } from './employeedetails/employeedetails.component';
import { SearchComponent } from './search/search.component';
import { FileuploadComponent } from './fileupload/fileupload.component';
import { HeaderComponent } from './header/header.component';
import { AdminComponent } from './admin/admin.component';
import { ExcelsheetComponent } from './excelsheet/excelsheet.component';




@NgModule({
  declarations: [
    AppComponent,
    HomepageComponent,
    CreateemployeeComponent,
    EmployeelistComponent,
    OnboardComponent,
    UpdateemployeeComponent,
    DeleteemployeeComponent,
    EmployeedetailsComponent,
    SearchComponent,
    FileuploadComponent,
    HeaderComponent,
    AdminComponent,
    ExcelsheetComponent,
    
  
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
    MatSidenavModule,
    MatIconModule,
    MatListModule,
  
   
  
    
    
    
  
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
