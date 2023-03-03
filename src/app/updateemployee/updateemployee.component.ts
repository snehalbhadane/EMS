import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../model/employee';
import { EmployeeService } from '../Service/employee.service';

@Component({
  selector: 'app-updateemployee',
  templateUrl: './updateemployee.component.html',
  styleUrls: ['./updateemployee.component.css']
})
export class UpdateemployeeComponent implements OnInit {
  emmployeeId:number;
  employee:Employee;
 
  constructor(private employeeService:EmployeeService,
    private route:ActivatedRoute,private router:Router){}
  ngOnInit(): void {
    this.employee = new Employee();
     this.emmployeeId = this.route.snapshot.params['emmployeeId'];
    this.employeeService.getEmployeeById(this.emmployeeId).subscribe(data=>{
     this.employee = data; 
    });
  
    }
    onSubmit(){

      this.updateEmployee();
    /*  this.employeeService.updateEmployee(this.id,this.employee).subscribe(data =>{
       this.getToEmployeeList(); 
     }
       ,error=>console.log(error));*/
     
    }
    updateEmployee() {
      this.employeeService.updateEmployee(this.emmployeeId, this.employee)
        .subscribe(data => {
          console.log(data);
          this.employee = new Employee();
          this.gotoList();
        }/* , error => console.log(error) */);
    }
    gotoList() {
      this.router.navigate(['/employees']);
    }
    /* getToEmployeeList(){
      this.router.navigate(['/employees'])
    }
   */
}
