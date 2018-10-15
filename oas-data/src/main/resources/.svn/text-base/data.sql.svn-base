insert into school (name, ukprn) values ('Oakwood', 10016805), ('De Stafford', 10061802), ('Reigate School', 10066018);

insert into institution (name, alias, min_courses, max_courses, course_selection_test) values 
('Reigate College', 'RC', 3, 4, '<p>Reigate College expect that all applications should select between 3 and 4 courses options. These options are an indication of what you are likely to want to study but are in no way set in stone. You are able to change your mind regarding your course selections at any point during the application process.</p><p>Reigate College offer a collection of A Level and BTEC qualifications and applicant are allowed to do a mixture of both A Level and BTECs.</p>'), 
('East Surrey College', 'ESC', 1, 2, null),
('Coulsdon College', 'CC', 1, 4, null);

insert into institution_partner_school (institution_id, school_id) values (1,1),(1,2),(1,3),(2,1),(2,2),(2,3),(3,2);

insert into contact_type (name) values ('Mother'), ('Father'), ('Guardian');

insert into title (code, description) values ('1','Mr'), ('2','Mrs'), ('3','Miss'), ('4','Ms'), ('5','Dr'), ('6','Rev'), ('7','Sir'), ('8','Lady'), ('9','Lord'), ('10','Dame'), ('11','Prof'), ('12','Capt'), ('98','None'), ('99','Other');
insert into gender (code, description) values ('M', 'Male'), ('F', 'Female'), ('O','Other');


insert into role (role_id, name) values (1, 'Admin'),(2, 'Institution'),(3, 'Applicant');
insert into user (legal_first_name, legal_surname, username, password, enabled, expired, locked) values ('Super', 'User', 'admin', '$2a$10$YH0gxgs3CmRDIRVi.otYb.Ciw5Sp/DgqECFij3mNcFOQw/gHDKJiK', 1, 0, 0);
insert into user (legal_first_name, legal_surname, username, password, enabled, expired, locked, dob, school_id) values ('John', 'Smith', 'jsmith@test.com', '$2a$10$YH0gxgs3CmRDIRVi.otYb.Ciw5Sp/DgqECFij3mNcFOQw/gHDKJiK', 1, 0, 0, '2000-09-01', 1);

insert into user_role (user_id, role_id) values (1, 1);
insert into user_role (user_id, role_id) values (2, 3);

insert into address (address_id, line1, town, postcode) values (1, 'Reigate College', 'Reigate', 'RH2 0SD');
insert into application (application_id, user_id, legal_first_name, legal_surname, dob, gender_id, address_id, school_id, email) values (1, 2, 'John', 'Smith', '2000-09-01', 1, 1, 1, 'jsmith@test.com');

insert into ethnicity_group (ethnicity_group_id, description) values (1, 'White'), (2, 'Mixed/Multiple Ethnic Group'), (3, 'Asian/Asian British'), (4, 'Black/African/Caribbean/Black British'), (9, 'Other');
insert into ethnicity (ethnicity_id, code, description, ethnicity_group_id) values (1, '31', 'English / Welsh / Scottish / Northern Irish / British', 1), (2, '32', 'Irish', 1), (3, '33', 'Gypsy or Irish Traveller', 1), (4, '34', 'Any Other White background', 1), (5, '35', 'White and Black Caribbean', 2), (6, '36', 'White and Black African', 2), (7, '37', 'White and Asian', 2), (8, '38', 'Mixed/multiple', 2), (9, '39', 'Indian', 3), (10, '40', 'Pakistani', 3), (11, '41', 'Bangladeshi', 3), (12, '42', 'Chinese', 3), (13, '43', 'Any other Asian background', 3), (14, '44', 'African', 4), (15, '45', 'Caribbean', 4), (16, '46', 'Any other Black/African/Caribbean background', 4), (17, '47', 'Arab', 9), (18, '98', 'Any other ethnic group', 9), (19, '99', 'Not provided', 9);
insert into lldd (lldd_id, code, description) values (4,'4','Visual impairment'), (5,'5','Hearing impairment'), (6,'6','Disability affecting mobility'), (7,'7','Profound complex disabilities'), (8,'8','Social and emotional difficulties'), (9,'9','Mental health difficulty'), (10,'10','Moderate learning difficulty'), (11,'11','Severe learning difficulty'), (12,'12','Dyslexia'), (13,'13','Dyscalculia'), (14,'14','Autism spectrum disorder'), (15,'15','Asperger’s syndrome'), (16,'16','Temporary disability after illness (for example post-viral) or accident'), (17,'17','Speech, Language and Communication Needs'), (93,'93','Other physical disability'), (94,'94','Other specific learning difficulty (e.g. Dyspraxia)'), (95,'95','Other medical condition (for example epilepsy, asthma, diabetes)'), (96,'96','Other learning difficulty'), (97,'97','Other disability'), (98,'98','Prefer not to say'), (99,'99','Not provided');


insert into qualification (qualification_id, title, level) values (3, 'GCSE Science', 2), (4, 'GCSE French', 2), (5, 'GCSE German', 2), (6, 'GCSE Spanish', 2);

insert into available_course (available_course_id, institution_id, level, code, title, description, entry_requirements, special_requirements, external_link) values 
(1, 1, 3, 'MAA', 'A Level Maths', 'An A Level in Mathematics. This course involves a lot of numbers. This descriptions is a long one which should go over multiple lines if required. The descriptions is continuing and will be fairly long when the end is reached. There is no end in sight but the will be soon. This may be the last sentence in the description but who knows. Oh no this is the last one.', 'Some requirements.', null, 'http://www.reigate.ac.uk/'),
(2, 1, 3, 'BIA', 'A Level Biology', 'An A Level in Biology. This description is testing the use of <strong>HTML tags</strong>, to see if these work.', 'Some requirements other.', null, null),
(3, 1, 3, 'CHA', 'A Level Chemistry', 'An A Level in Chemistry. <a href="http://www.reigate.ac.uk">Link</a>.', 'Some requirements other.', null, null);
