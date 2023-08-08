insert into GAMESUMMARY (CLIENTGESTURE, SERVERGESTURE, RESULT, TIMEPLAYED)
values('ROCK','ROCK','TIE','2010-05-12 00:00:00.0');
insert into GAMESUMMARY (CLIENTGESTURE, SERVERGESTURE, RESULT, TIMEPLAYED)
values('PAPER','ROCK','WIN','2011-05-12 00:00:00.0');
insert into GAMESUMMARY (CLIENTGESTURE, SERVERGESTURE, RESULT, TIMEPLAYED)
values('SCISSORS','ROCK','LOSS','2012-05-12 00:00:00.0');
insert into EVENTS (CODE, TITLE, DESCRIPTION)
values('FMSC170', 'Family Science', 'Learn about xyz');
insert into EVENTS (CODE, TITLE, DESCRIPTION)
values('CMSC399', 'Intro to Music', 'introduction to music');
insert into CUSTOMERS (CUSTOMERID, NAME, EMAIL, PASSWORD)
values(1, 'Jay-Z', 'jayz@gmail.com','2abcd123');
insert into REGISTRATIONS (EVENT_ID, CUSTOMER_ID, REGISTRATION_DATE, NOTES)
values ('1', '2', '2019-01-13 00:00:00.0', 'omg');
insert into REGISTRATIONS (EVENT_ID, CUSTOMER_ID, REGISTRATION_DATE, NOTES)
values ('1', '1', '2019-01-13 00:00:00.0', 'i think this finally works');
insert into REGISTRATIONS (EVENT_ID, CUSTOMER_ID, REGISTRATION_DATE, NOTES)
values ('1', '1', '2019-01-13 00:00:00.0', 'it was seriously just a naming issue');
insert into REGISTRATIONS (EVENT_ID, CUSTOMER_ID, REGISTRATION_DATE, NOTES)
values ('1', '2', '2019-01-13 00:00:00.0', 'thanks Cameron');
insert into REGISTRATIONS (EVENT_ID, CUSTOMER_ID, REGISTRATION_DATE, NOTES ) 
values ( '1', '2', '2019-01-13 00:00:00.0', 'na' );