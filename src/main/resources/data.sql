insert into GAMESUMMARY (CLIENTGESTURE, SERVERGESTURE, RESULT, TIMEPLAYED)
values('ROCK','ROCK','TIE','2010-05-12 00:00:00.0');
insert into GAMESUMMARY (CLIENTGESTURE, SERVERGESTURE, RESULT, TIMEPLAYED)
values('PAPER','ROCK','WIN','2011-05-12 00:00:00.0');
insert into GAMESUMMARY (CLIENTGESTURE, SERVERGESTURE, RESULT, TIMEPLAYED)
values('SCISSORS','ROCK','LOSS','2012-05-12 00:00:00.0');
insert into EVENTS (EVENTID, CODE, TITLE, DESCRIPTION)
values(1, 'FMSC170', 'Family Science', 'Learn about xyz');
insert into EVENTS (EVENTID, CODE, TITLE, DESCRIPTION)
values(2, 'CMSC399', 'Intro to Music', 'introduction to music');
insert into CUSTOMERS (USERID, NAME, EMAIL, TIMESTARTED)
values(123,'Jay-Z', 'jayz@gmail.com','2012-05-12 00:00:00.0');
--insert into REGISTRATIONS (EVENT_ID, REGISTRATION_DATE, NOTES)
--values ('4', '2019-01-15T00:00:00.000+0000', 'omg');
--insert into REGISTRATIONS (EVENT_ID, REGISTRATION_DATE, NOTES)
--values ('1', '1', '2020-01-15T00:00:00.000+0000', 'i think this finally works');
--insert into REGISTRATIONS (EVENT_ID, REGISTRATION_DATE, NOTES)
--values ('2', '10', '2021-01-15T00:00:00.000+0000', 'it was seriously just a naming issue');
--insert into REGISTRATIONS (EVENT_ID, REGISTRATION_DATE, NOTES)
--values ('3', '20', '2022-01-15T00:00:00.000+0000', 'thanks Cameron');
insert into REGISTRATIONS (REGISTRATIONID, EVENT_ID, REGISTRATION_DATE, NOTES) 
values ( 1, 3, '2019-01-13 00:00:00.0', 'na' )
insert into CUSTOMERS (CUSTOMERID, NAME, EMAIL, PASSWORD)
values(1, 'Jay-Z', 'jayz@gmail.com','2abcd123');
