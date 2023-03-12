import { EmployeeFeedback } from "./employeeFeedback";
import { Skill } from "./skill";

export class EmployeeSkillsRating {
    id !: number;
    rating !: number;
    remarks !: string;
    skill !: Skill;
    employeeFeedback !: EmployeeFeedback;
}