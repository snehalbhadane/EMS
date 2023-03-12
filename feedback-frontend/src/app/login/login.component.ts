import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { CompetencyMember } from '../competency-member';
import { LoginSignupService } from '../login-signup.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

 cm1=new CompetencyMember();
creadintialResponse='';

  constructor(private service:LoginSignupService,private myrouter:Router, ) { }


  ngOnInit(): void {

  }
  opendash(){
    this.myrouter.navigate(['/dashboard'])
  }


  loginUser(){

    this.service.loginFromBackend(this.cm1).subscribe(
      data=>{console.log("response recived");
      this.myrouter.navigate(['/AfterSucessLogin'])
    },
      error=>{ console.log("exception occured");

      this.creadintialResponse="BadCreditials Enter Correct Email id and password "
  }
    )
  }
  registrationForm(){
    this.myrouter.navigate(['/ForNewRegistration'])

  }
}
function loginUser() {
  throw new Error('Function not implemented.');
}

 
 


