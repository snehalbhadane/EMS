import { CompetencyMember } from './../competency-member';
export class EmployeeFeedbackFile {
    id !: number;
    fileName !: string;
    uploadedOn !: Date;
    uploadedBy !: CompetencyMember;
}