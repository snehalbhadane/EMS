import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable()
export class ApiService {

    constructor(private http: HttpClient) { }

     get(url: string): any {
        return this.http.get(environment.apiURL + url);
    }

    post(url: string, data: string) : any {
        alert(environment.apiURL + url +" : "+ data)
        return this.http.post(environment.apiURL + url, data)
    }
}