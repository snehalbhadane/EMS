import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../model/employee';
import { EmployeeService } from '../Service/employee.service';

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
  constructor(private employeeService:EmployeeService,private router :Router){}

  ngOnInit(): void {
     this.getEmployees();
    
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


