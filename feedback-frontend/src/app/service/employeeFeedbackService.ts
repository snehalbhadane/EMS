import { Injectable } from '@angular/core';
import { ApiService } from './apiService';

@Injectable()
export class EmployeeFeedbackService {

    constructor(private apiService: ApiService) { }

    getSkills() {
        return this.apiService.get("/feedback/api/allSkill");
    }

    getEmployees() {
        return this.apiService.get("/feedback/api/allEmployee");
    }

    getEmployeeFeedbacks() {
        return this.apiService.get("/feedback/api/allEmployeeFeedback");
    }

    saveEmployeeFeedback(employeeFeedback: string) {
        return this.apiService.post("/feedback/api/saveEmployeeFeedback", employeeFeedback);
    }
}