import { EmployeeFeedback } from './../model/employeeFeedback';
import { Employee } from './../model/employee';
import { Component, OnInit } from '@angular/core';
import { Skill } from '../model/skill';
import { Router } from '@angular/router';
import { EmployeeFeedbackService } from '../service/employeeFeedbackService';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-add-feedback',
  templateUrl: './add-feedback.component.html',
  styleUrls: ['./add-feedback.component.css']
})
export class AddFeedbackComponent implements OnInit {

  ef = new EmployeeFeedback;
  skills !: Skill[];
  employees !: Employee[];
  feedbackForm !: FormGroup;
  emp !: Employee;

  constructor(private myrouter:Router, private service : EmployeeFeedbackService,
    private formBuilder: FormBuilder) { }

  ngOnInit(): void {

    this.feedbackForm = this.formBuilder.group({
      id: [''],
      overallExperience : ['', [Validators.required]],
      projectExperience : ['', [Validators.required]],
      employee : ['', [Validators.required]]
    });

    this.getSkills();
    this.getEmployees();
  }

  async getSkills() {
     this.service.getSkills().subscribe((data: Skill[]) => {
     this.skills = data;
    });
  }

  async getEmployees() {
     this.service.getEmployees().subscribe((data: Employee[]) => {
     this.employees = data;
    });
  }  

  onSubmit() {
  
    var empFeedbackObj = {

    'overallExperience' : this.feedbackForm.get('overallExperience')?.value,
    'projectExperience' : this.feedbackForm.get('projectExperience')?.value,
    'employee' : {'id' : this.feedbackForm.get('employee')?.value}
  }
  
  alert("Emp id : "+empFeedbackObj.employee.id+" , overallExperience : "+empFeedbackObj.overallExperience
  +" , projectExperience : "+empFeedbackObj.projectExperience);

  // let response =  await this.service.saveEmployeeFeedback(JSON.stringify(empFeedbackObj));
  //   alert(response);

  let response = this.service.saveEmployeeFeedback(JSON.stringify(empFeedbackObj)).subscribe(() => {
        console.log("Hi")
        
      })

  } 
}