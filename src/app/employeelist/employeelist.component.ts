import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../model/employee';
import { EmployeeService } from '../Service/employee.service';
import * as XLSX from 'xlsx';

@Component({
  selector: 'app-employeelist',
  templateUrl: './employeelist.component.html',
  styleUrls: ['./employeelist.component.css']
})
export class EmployeelistComponent implements OnInit {
deleteEmp(arg0: any) {
throw new Error('Method not implemented.');
}
  employees: Employee[];
empList: any;
serchtext: any;
fileName="Employee Details.xlsx"
  constructor(private employeeService:EmployeeService,private router :Router){}

  ngOnInit(): void {
     this.getEmployees();
    
   }
//export the data into excelsheet
 userList=[
  {
    "employeeId":101662,
    "employeeName":"Vamshi",
    "email":"vamshi@gmail.com",
    "designation":"software Engineer",
    "grade":"B.tech",
    "resourceType":"Developer",
    "Doj":"2022-08-23",
    "totalExp":3,
    "reporting Manager":"Yogeswar",
    "currentLocation":"Hyderbad",
    "currentAllocation":"Pune",
    "project":"Poc Project"
}
 ]
   exportexcel():void{
   let element=document.getElementById('excel-table')

   const ws:XLSX.WorkSheet = XLSX.utils.table_to_sheet(element)

   const wb:XLSX.WorkBook =XLSX.utils.book_new()

   XLSX.utils.book_append_sheet(wb,ws,'Sheet1')
   XLSX.writeFile(wb,this.fileName)
      
   }
   private getEmployees(){
    this.employeeService.getEmployeesList().subscribe(data=>{
      this.employees=data;
    }/* ,error=>console.log(error) */);
   }
   employeeDetails(employeeId:number){
    this.router.navigate(['employeedetails',employeeId]);
   }
   updateEmployee(employeeId:number){
   this.router.navigate(['updateemployee',employeeId]);
   }
   deleteEmployee(employeeId:number) {
    this.employeeService.deleteEmployee(employeeId).subscribe(data =>{
      console.log(data);
      this.getEmployees();
    })

   
    /* serchtext:string='';

    onsearchtextentred(searchvalue:string){
      this.serchtext=searchvalue;
      console.log(this.serchtext);
    }*/
   }  
   
}


