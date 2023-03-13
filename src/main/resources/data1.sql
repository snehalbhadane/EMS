INSERT INTO EMPLOYEE ( EMPLOYEE_ID , EMPLOYEE_NAME , EXPERIENCE_IN_MONTH  ) VALUES (101,'Prachi', 36);
INSERT INTO SKILLS ( SKILL_ID , SKILL_NAME ) VALUES
(1, 'JAVA'),
(2, 'SQL'),
(3, 'Spring'),
(4, 'Angular'),
(5, 'React'),
(6, 'JPA'),
(7, 'DevOps');

INSERT INTO "employee-skill-mapping" ( EMPLOYEE_ID , SKILL_ID ) VALUES
(101,1),
(101,2),
(101,3),
(101,4),
(101,5),
(101,6),
(101,7);
--

INSERT INTO "evaluation-form" VALUES (21,'JAVA_DEVELOPER_2-3_SLB', 'JD HERE',36);

INSERT INTO ASSESSMENT ( ASSESSMENT_ID , ASSESSMENT_NAME , EVALUATION_FORM_ID ) VALUES
(201,'SLB_02032023_mock_interview', 21);


INSERT INTO "assessment-employee-mapping" ( ASSESSMENT_ID , EMPLOYEE_ID ) VALUES (201,101);



INSERT INTO "assessment-feedback"( ASSESSMENT_FEEDBACK_ID , ASSESSMENT_ID , EMPLOYEE_ID ) VALUES (11, 201,101);

INSERT INTO "skill-ratings" ( SKILL_RATING_ID , SKILL_ID , RATING , REMARKS ) VALUES
(301, 1, 7,'looks good in core java'),
(302, 2, 6,'looks good in sql need improvement in PLSQL'),
(303, 3, 8,'looks very good'),
(304, 4, 5,'beginner'),
(305, 5, 7,'looks good in react, need more experience'),
(306, 6, 9,'Strong in Entity design'),
(307, 7, 4,'Need to learn'),

INSERT INTO "assessment-feedback_skill_rating_list"
VALUES
(11,301),
(11,302),
(11,303),
(11,304),
(11,305),
(11,306),
(11,307);


SELECT * FROM EMPLOYEE;
SELECT * FROM SKILLS ;
SELECT * FROM "employee-skill-mapping";
SELECT * FROM "evaluation-form";
SELECT * FROM ASSESSMENT ;
SELECT * FROM "assessment-employee-mapping";
SELECT * FROM "assessment-feedback" ;
SELECT * FROM "skill-ratings";
SELECT * FROM "assessment-feedback_skill_rating_list";