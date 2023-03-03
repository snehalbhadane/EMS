import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CompetencyMember } from '../Service/competency-member';
import { LoginSignupService } from '../Service/login-signup.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
 
  cm1=new CompetencyMember();
  creadintialResponse='';
  
    constructor(private service:LoginSignupService,private myrouter:Router) { }
  
    ngOnInit(): void {
  
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
