DROP DATABASE IF EXISTS KNK;
CREATE DATABASE KNK;
USE KNK;


#Tabela per lendet mesimore
CREATE TABLE Subjects
(
	subjectID VARCHAR(255),
	subjectName VARCHAR(255), 
	PRIMARY KEY(subjectID)
); 

#Tabela per qytetet
CREATE TABLE City
(
	cityID VARCHAR(255),
	cityName VARCHAR(255),
	state VARCHAR(255),
	postalCode INTEGER,
    PRIMARY KEY(cityID)
);

insert into city values('1', 'Prishtine', 'Kosove', '10000');

#Tabela per adresat e banimit
CREATE TABLE Address
( 
	addressID VARCHAR(255),
	cityID VARCHAR(255),
	street VARCHAR(255),
	PRIMARY KEY (addressID),
	FOREIGN KEY (cityID) REFERENCES City(cityID) ON DELETE CASCADE ON UPDATE CASCADE
);

insert into Address values('1', '1', 'Skenderbeu');


/*
	Tabela per paralelet ku zhvillohet mesimi. ID lexohet si ne vijim:
    Marrim shembull ID: 101 (10/1), 113 (11/3), 125 (12/5).
    Dy numrat e pare tregojne klasen ndersa i fundit tregon paralelen.
*/
CREATE TABLE ClassRoom 
(
	classRoomNumber VARCHAR(255),
	PRIMARY KEY(classRoomNumber)
);

#Tabela per studentet (nxenesit)
CREATE TABLE Student
(
	studentID VARCHAR(255) not null,
    studentName VARCHAR(255) not null,
    studentSurname VARCHAR(255) not null,
    gender CHAR(1) not null,
    phoneNumber VARCHAR(255) not null,
    email VARCHAR(255) not null unique,
	password VARCHAR(255) not null,
    classRoomNumber VARCHAR(255) not null,
    addressID VARCHAR(255) not null,
    birthDate varchar(255) not null,
    age INTEGER not null,
    PRIMARY KEY(studentID),
    FOREIGN KEY(classRoomNumber) REFERENCES ClassRoom(classRoomNumber) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(addressID) REFERENCES Address(addressID) ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE Grades
(
	periodID VARCHAR(255),
	studentID VARCHAR(255),
	subjectID VARCHAR(255),
    commitment REAL,
    tasks REAL,
	essay REAL,
    debates REAL,
    projects REAL,
    tests REAL,
    quizzess REAL,
	portfolio REAL,
	markPart1 REAL,
    finalTest REAL,
	markPart2 REAL,
    finalPeriodMark REAL,
	PRIMARY KEY(periodID, studentID, subjectID),
	FOREIGN KEY(studentID) REFERENCES Student(studentID) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY(subjectID) REFERENCES Subjects(subjectID) ON DELETE CASCADE ON UPDATE CASCADE
 );


#Tabele per paraqitjen e notes perfundimtare te llogariture nga tre periodat (Nota vjetore).
 CREATE TABLE finalGrade
(	
	studentID VARCHAR(255),
    subjectID VARCHAR(255),
    finalGrade REAL,
    PRIMARY KEY(studentID, subjectID),
    FOREIGN KEY(subjectID) REFERENCES Subjects(subjectID) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(studentID) REFERENCES Student(studentID) ON DELETE CASCADE ON UPDATE CASCADE
);


#Tabela per te dhenat e mesimdheneseve.
CREATE TABLE Teacher
(
	teacherID VARCHAR(255),
	teacherName VARCHAR (20) NOT NULL,
	teacherSurname VARCHAR(20) NOT NULL,
	phoneNumber INTEGER,
	email VARCHAR(40) unique not null,
    password VARCHAR(255),
    addressID VARCHAR(255),
	subjectID VARCHAR(50),
    PRIMARY KEY(teacherID),
	FOREIGN KEY(addressID) REFERENCES Address(addressID) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(subjectID) REFERENCES Subjects(subjectID) ON DELETE CASCADE ON UPDATE CASCADE
);


#Krijimi i tabeles me mundesi pershkrimi per noten. P.s. 5 - Shkelqyeshem.
CREATE TABLE gradeDescription 
(
	gradeID VARCHAR(255),
	descriptionGrade VARCHAR(255),
    PRIMARY KEY(gradeID)
);

#Tabela per te dhenat e administratoreve.
CREATE TABLE Administrator
(
	administratorID VARCHAR(20),
    name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    PRIMARY KEY(administratorID));

INSERT INTO Administrator VALUES 
('1','bardhi','bardhi','052887890c09cb97fde4008cf34823285aa91d0e'),
('2','bleona','bleona','1b6a76f7c77639f409ca003b937674bfcf1deef2'),
('3','fjolla','fjolla','6ec64679402560e7df82e40ef88ff84aa77a4662'),
('4','elda','elda','ed0ff82d34be4f36aa45b75542b24697080d28c6'),
('5','vesa','vesa','19b6e84f9a56c3f33185e5d32b37360c9aba9217'),
('6','rina','rina','70e21878d268fa8f82817f9278f8bae0fb108950'),
('7','donika','donika','ee1d07e265c1b3b346dd87f7d48d29b0b508773d'),
('8','vigan','vigan','5d62808c54c7d5e7218c0d65c3a6a36400cb34d8');


INSERT INTO Subjects VALUES
('1000', 'Gjuhe Shqipe'),
('1001', 'Gjuhe Angleze'),
('1002', 'Gjuhe Gjermane'),
('1003', 'Art Muzikor'),
('1004', 'Art Figurativ'),
('1005', 'Matematike'),
('1006', 'Biologji'),
('1007', 'Fizike'),
('1008', 'Kimi'),
('1009', 'Gjeografi'),
('1010', 'Histori'),
('1011', 'Edukate Fizike'),
('1012', 'TIK'),
('1013', 'Kultura dhe Shoqeria'),
('1014', 'Ekologji');


INSERT INTO ClassRoom VALUES
('101'),
('102'),
('103'),
('104'),
('105'),
('106');


INSERT INTO City VALUES
('2000', 'Prishtine', 'Kosove', '10000'),
('2001', 'Kline', 'Kosove', '32000'),
('2002', 'Drenas', 'Kosove', '11000'),
('2003', 'Istog', 'Kosove', '12000'),
('2004', 'Gjakove', 'Kosove', '50000')
('2005', 'Suhareke', 'Kosove', '12400'),
('2006', 'Prizren', 'Kosove', '22000'),
('2007', 'Ferizaj', 'Kosove', '32000');


INSERT INTO gradeDescription VALUES
('5', 'Shkelqyeshem'),
('4', 'Shume mire'),
('3', 'Mire'),
('2', 'Mjaftueshem'),
('1', 'dobet');


CREATE VIEW finalPeriodMark AS 
SELECT studentID, subjectID, SUM(finalPeriodMark) / 3 AS 'finalPeriodMark'
FROM Grades 
GROUP BY studentID, subjectID;

SELECT * FROM finalPeriodMark;

CREATE VIEW StudentsGPA AS
SELECT studentID, AVG(finalPeriodMark) AS 'Average'
FROM finalPeriodMark
GROUP BY studentID;

SELECT * FROM StudentsGPA;

CREATE VIEW mjaftueshem(mjaft) AS
SELECT COUNT(*)
FROM StudentsGPA
WHERE Average >= 1.5 AND Average < 2.5;

CREATE VIEW mire(mire) AS
SELECT COUNT(*)
FROM StudentsGPA
WHERE Average >= 2.5 AND Average < 3.5;

CREATE VIEW shumemire (shumemire) AS
SELECT COUNT(*)
FROM StudentsGPA
WHERE Average >= 3.5 AND Average < 4.5;

CREATE VIEW shkelqyeshem(shkelqyeshem) AS
SELECT COUNT(*)
FROM StudentsGPA
WHERE Average >= 4.5 AND Average <= 5;


CREATE VIEW CountStudents(mjaft, mire, shumemire, shkelqyeshem) AS
SELECT mjaft, mire, shumemire, shkelqyeshem
FROM mjaftueshem, mire, shumemire, shkelqyeshem;


SELECT * FROM CountStudents;

CREATE VIEW NrLendeve AS
SELECT subjectID, count(teacherID) AS 'NumriProfesoreve'
FROM Teacher
GROUP BY(subjectID);

SELECT * from Nrlendeve;

select * from teacher;

