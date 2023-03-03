import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { CompetencyMember } from './competency-member';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginSignupService {

  constructor(private http:HttpClient) { }

  public loginFromBackend(cm:CompetencyMember):Observable<CompetencyMember>{

    return this.http.post<CompetencyMember>("http://localhost:8082/login",cm)
    
  }
  public SignupFromBackend(cm:CompetencyMember):Observable<CompetencyMember>{

    return this.http.post<CompetencyMember>("http://localhost:8082/registeruser",cm)
    
  }
}
