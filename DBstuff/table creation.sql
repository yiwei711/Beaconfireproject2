create database project2;
use project2;
create table person(
id int primary key not null auto_increment,
firstName varchar(50),
lastName varchar(50),
middleName varchar(50),
email varchar(50),
cellphone varchar(15),
alternatePhone varchar(15),
gender varchar(1),
ssn varchar(10),
DOB varchar(20));

create table user(
id int primary key not null auto_increment,
userName varchar(50),
email varchar(50),
password varchar(50),
personID int not null,
createDate varchar(50),
modificationDate varchar(50),
foreign key (personID) references person(id)
);

create table role(
id int primary key not null auto_increment,
roleName varchar(50),
description varchar(200),
createDate varchar(50),
modificationDate varchar(50),
lastModificationUser int);

create table UserRole(
id int primary key not null auto_increment,
userID int not null,
roleID int not null,
activeFlag boolean,
createDate varchar(50),
modificationDate varchar(50),
lastModificationUser int,
foreign key (userID) references user(id),
foreign key (roleID) references role(id));

create table permission(
id int primary key not null auto_increment,
permissionName varchar(50),
permissionDescription varchar(200),
createDate varchar(50),
modificationDate varchar(50),
lastModificationUser int);

create table rolePermission(
id int primary key not null auto_increment,
roleID int not null,
permissionID int not null,
activeflag boolean,
createDate varchar(50),
modificationDate varchar(50),
lastModificationUser int,
foreign key (roleID) references role(id),
foreign key (permissionID) references permission(id));

create table registrationToken(
id int primary key not null auto_increment,
token varchar(200),
validDuration int,
email varchar(50),
createdBy varchar(50));

create table employee(
id int primary key not null auto_increment,
personID int not null,
title varchar(50),
managerID int not null,
startDate varchar(20),
endDate varchar(20),
Avatar varchar(50),
car varchar(50),
visaStatusID varchar(50),
visaStartDate varchar(50),
visaEndDate varchar(50),
driverLisence varchar(50),
driverLisence_expirationDate varchar(50),
houseId int not null,
foreign key (personID) references person(id));

create table contact(
id int primary key not null auto_increment,
personID int not null,
relationship varchar(50),
title varchar(50),
isReference boolean,
isEmergency boolean,
isLandlord boolean,
foreign key (personID) references person(id));

create table address(
id int primary key not null auto_increment,
addressline1 varchar(50),
addressline2 varchar(50),
city varchar(50),
zipcode varchar(50),
stateName varchar(50),
stateAbbr varchar(3),
personID int not null,
foreign key (personID) references person(id));

create table visaStatus(
id int primary key not null auto_increment,
visaType varchar(20),
active boolean,
modificationDate varchar(20),
createUser varchar(50));

create table personalDocument(
id int primary key not null auto_increment,
employeeID int not null,
path varchar(50),
title varchar(50),
comment varchar(200),
createdDate varchar(50),
createdBy varchar(50),
foreign key (employeeID) references employee(id));

create table digitalDocument(
id int primary key not null auto_increment,
type varchar(1),
required boolean,
templateLocation varchar(50),
description varchar(200));

create table applicationWorflow(
id int primary key not null auto_increment,
employeeID int not null,
createDate varchar(20),
modificationDate varchar(20),
status boolean,
comments varchar(200),
type varchar(50),
foreign key (employeeID) references employee(id));

create table house(
id int primary key not null auto_increment,
contactID int not null,
address varchar(50),
numberOfPersons int,
foreign key (contactID) references contact(id));

create table facility(
id int primary key not null auto_increment,
type varchar(50),
desciption varchar(200),
quantity int,
houseID int not null,
foreign key (houseID) references house(id));

create table facilityReport(
id int primary key not null auto_increment,
title varchar(50),
employeeID int not null,
reportDate varchar(50),
description varchar(50),
status varchar(50),
foreign key (employeeID) references employee(id));

create table facilityReportDetail(
id int primary key not null auto_increment,
reportID int not null,
employeeID int not null,
comments varchar(200),
createdDate varchar(50),
lastModificationDate varchar(50),
foreign key (reportID) references facilityReport(id),
foreign Key (employeeID) references employee(id));