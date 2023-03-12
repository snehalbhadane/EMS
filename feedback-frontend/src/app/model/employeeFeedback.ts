import { CompetencyMember } from './../competency-member';
import { Employee } from './employee';
import { EmployeeFeedbackFile } from './employeeFeedbackFile';
import { EmployeeSkillsRating } from './employeeSkillsRating';
export class EmployeeFeedback {
    id !: number;
    overallExperience !: number;
    projectExperience !: number;
    comments !: string;
    suggestion !: string;
    createdOn !: Date;
    employeeFeedbackFile !: EmployeeFeedbackFile;
    employee !: Employee;
    createdBy !: CompetencyMember;
    employeeSkillsRatings !: EmployeeSkillsRating[];
}