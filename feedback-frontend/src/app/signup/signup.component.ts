import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { CompetencyMember } from '../competency-member';
import { LoginSignupService } from '../login-signup.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  SignupResponse='';
  cm1=new CompetencyMember();
  constructor(private service:LoginSignupService,private myrouter1:Router) { }

  ngOnInit(): void {
  }
  signupUser(){
    this.service.SignupFromBackend(this.cm1).subscribe(
      data=>{ console.log("response recived");
      this.SignupResponse="Signup Sucessful";
    },
      error=>{
        console.log("Exception Occured");
        this.SignupResponse=error.error;

      }
      
    )
  }
  loginform(){
    this.myrouter1.navigate(['/'])
  }
}
