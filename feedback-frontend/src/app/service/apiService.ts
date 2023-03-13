import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

    constructor(private http: HttpClient) { }

     get(url: string): any {
        return this.http.get(environment.apiURL + url);
    }

    post(url: string, data: string) : any {
        return this.http.post(environment.apiURL + url, data, this.createHeader('application/json')).toPromise();
    }

    postData(url: string, data: string) : any {
        return this.http.post(environment.apiURL + url, data);
    }

    getFile(url: string) : any {
        return this.http.get(environment.apiURL + url, {responseType : 'blob'})
    }

    private createHeader(contentType: string): any {
        return { headers: new HttpHeaders({ 'Content-Type': contentType }) };
    }
}