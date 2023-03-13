import { EmployeeFeedback } from "./employeeFeedback";
import { Skill } from "./skill";

export class EmployeeSkillsRating {
    id !: number;
    rating !: any;
    remarks !: any;
    skill !: Skill;
    employeeFeedback !: EmployeeFeedback;
}