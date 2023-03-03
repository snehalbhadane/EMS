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
  employees: Employee[];
  constructor(private employeeService:EmployeeService,private router :Router){}

  ngOnInit(): void {
     this.getEmployees();
    
   }

   private getEmployees(){
    this.employeeService.getEmployeesList().subscribe(data=>{
      this.employees=data;
    }/* ,error=>console.log(error) */);
   }
   employeeDetails(id:number){
    this.router.navigate(['employeedetails',id]);
   }
   updateEmployee(id:number){
   this.router.navigate(['update-employee',id]);
   }
   deleteEmployee(id:number) {
    this.employeeService.deleteEmployee(id).subscribe(data =>{
      console.log(data);
      this.getEmployees();
    })
   }
   
}


