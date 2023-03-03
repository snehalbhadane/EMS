import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../model/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private baseURL="http://localhost:8080/employee";
  constructor(private httpClient:HttpClient) { }


  getEmployeesList():Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(this.baseURL);

  }
  createEmployee(employee:Employee):Observable<Object>{
      return this.httpClient.post((this.baseURL),employee);
  }
  getEmployeeById(employeeId: number): Observable<any> {
    return this.httpClient.get(`${this.baseURL}/${employeeId}`);
  }
  updateEmployee(employeeId: number, value: any): Observable<Object> {
    return this.httpClient.put(`${this.baseURL}/${employeeId}`, value);
  }
  deleteEmployee(employeeId: number): Observable<any> {
    return this.httpClient.delete(`${this.baseURL}/${employeeId}`, { responseType: 'text' });
  }

}

 
