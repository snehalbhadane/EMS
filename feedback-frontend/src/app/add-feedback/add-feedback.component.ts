import { EmployeeSkillsRating } from './../model/employeeSkillsRating';
import { EmployeeFeedback } from './../model/employeeFeedback';
import { Employee } from './../model/employee';
import { Component, OnInit } from '@angular/core';
import { Skill } from '../model/skill';
import { Router } from '@angular/router';
import { EmployeeFeedbackService } from '../service/employeeFeedbackService';
import { FormBuilder, FormGroup, Validators, FormArray } from '@angular/forms';

@Component({
  selector: 'app-add-feedback',
  templateUrl: './add-feedback.component.html',
  styleUrls: ['./add-feedback.component.css']
})
export class AddFeedbackComponent implements OnInit {
  employeeFeedback !: EmployeeFeedback;
  skills !: Skill[];
  employees !: Employee[];
  feedbackForm !: FormGroup;
  ratingInput = new FormArray([]);
  commentInput = new FormArray([]);
  employeeSkillsRatings : any[] = [];

  constructor(private router: Router, private service : EmployeeFeedbackService,
    private formBuilder: FormBuilder) { }

  ngOnInit(): void {

    this.feedbackForm = this.formBuilder.group({
      id: [''],
      overallExperience : ['', Validators.required],
      projectExperience : ['', Validators.required],
      employee : ['', Validators.required],
      comments : ['', Validators.required],
      suggestion : ['']
    });

     this.getSkills();
    this.getEmployees();
  }

  async getSkills() {
     this.service.getSkills().subscribe((data: Skill[]) => {
     this.skills = data;

     if(this.skills != null) {
      for(let i=0; i<this.skills.length; i++) {
      }
    } 
    
    });
  }

  async getEmployees() {
     this.service.getEmployees().subscribe((data: Employee[]) => {
     this.employees = data;
    });
  }

  ratingInputCount(event: any) {
    this.ratingInput.push(event.target.value)
  }

  commentInputCount(event : any) {
    this.commentInput.push(event.target.value)
  }

  async onSubmit() {

    this.employeeSkillsRatings.slice(0, this.skills.length);

    if(this.skills != null) {
      for(let i=0; i<this.skills.length; i++) {
       const employeeSkillsRating = new EmployeeSkillsRating();
       employeeSkillsRating.skill = this.skills[i];
       employeeSkillsRating.rating = this.ratingInput.get([i]);
       employeeSkillsRating.remarks = this.commentInput.get([i]);
       this.employeeSkillsRatings.push(employeeSkillsRating);
      }
    }

    var empFeedbackObj = {
    'overallExperience' : this.feedbackForm.get('overallExperience')?.value,
    'projectExperience' : this.feedbackForm.get('projectExperience')?.value,
    'employee' : {'id' : this.feedbackForm.get('employee')?.value},
    'comments' : this.feedbackForm.get('comments')?.value,
    'suggestion' : this.feedbackForm.get('suggestion')?.value,
    'employeeSkillsRatings' : this.employeeSkillsRatings
  }
 
  let response = await this.service.saveEmployeeFeedback(JSON.stringify(empFeedbackObj));
    this.employeeFeedback = response;

     if(this.employeeFeedback != null && this.employeeFeedback.id > 0) {
      this.router.navigate(['/feedback-list'])
     }
  } 
}