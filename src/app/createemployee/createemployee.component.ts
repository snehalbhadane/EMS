import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../model/employee';
import { EmployeeService } from '../Service/employee.service';

@Component({
  selector: 'app-createemployee',
  templateUrl: './createemployee.component.html',
  styleUrls: ['./createemployee.component.css']
})
export class CreateemployeeComponent implements OnInit {
  employee:Employee=new Employee();

  constructor(private employeeService:EmployeeService,
    private router:Router){}

  ngOnInit(): void {
   
  }
  saveEmployee(){
    this.employeeService.createEmployee(this.employee).subscribe(data=>{
      console.log(data);
    });/*,
    error => console.log(error)); */
  }
  goToEmployeeList(){
    this.router.navigate(['./employees']);

  }
  onSubmit(){
    console.log(this.employee);
    this.saveEmployee();
  }
 
}
