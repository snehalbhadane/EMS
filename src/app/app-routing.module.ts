import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateemployeeComponent } from './createemployee/createemployee.component';
import { DeleteemployeeComponent } from './deleteemployee/deleteemployee.component';
import { EmployeedetailsComponent } from './employeedetails/employeedetails.component';
import { EmployeelistComponent } from './employeelist/employeelist.component';
import { HomepageComponent } from './home/homepage/homepage.component';
import { OnboardComponent } from './onboard/onboard.component';
import { UpdateemployeeComponent } from './updateemployee/updateemployee.component';
import { FileuploadComponent } from './fileupload/fileupload.component';
import { AdminComponent } from './admin/admin.component';
import { ExcelsheetComponent } from './excelsheet/excelsheet.component';

const routes: Routes = [
   { path: '',redirectTo: 'home',  pathMatch: 'full'},  
   { path: 'home',component:HomepageComponent}, 
   {path:'admin',component:AdminComponent},
   {path:'createemployee',component:CreateemployeeComponent},
   {path:'onboard',component:OnboardComponent},  
   {path:'employeelist',component:EmployeelistComponent},
   {path:'updateemployee/:employeeId',component:UpdateemployeeComponent},
   {path:'deleteemployee/:employeeId',component:DeleteemployeeComponent},
   {path:'employeedetails/:employeeId',component:EmployeedetailsComponent},
   {path:'fileupload',component:FileuploadComponent},
   {path:'excelsheet',component:ExcelsheetComponent}
   
   
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
