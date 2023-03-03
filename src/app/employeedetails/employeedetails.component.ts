import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Employee } from '../model/employee';
import { EmployeeService } from '../Service/employee.service';

@Component({
  selector: 'app-employeedetails',
  templateUrl: './employeedetails.component.html',
  styleUrls: ['./employeedetails.component.css']
})
export class EmployeedetailsComponent implements OnInit{
  employeeId:number
  employee:Employee
  
  constructor(private route:ActivatedRoute,private employeeService:EmployeeService){}
 
  ngOnInit(): void {
    this.employeeId =this.route.snapshot.params['employeeId'];
   this.employee=new Employee();
   this.employeeService.getEmployeeById(this.employeeId).subscribe(data=>{
   this.employee=data;
   });
   
  }
}
