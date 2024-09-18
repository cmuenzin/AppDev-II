/*neuer Bewerber*/
insert into 'Bewerber' (
    bewerberid,
    vorname,
    nachname,
    telefonnummer,
    email
)
values (
    bewerberid,
    vorname,
    nachname,
    telefonnummer,
    email
);


/*Bewerberdaten ändern*/
update Bewerber
set telefonnummer = /Telefonnummer/
where bewerberid = /bewerberid/

update Bewerber
set email = /email/
where bewerberid = /bewerberid/;


/*Bestätigungsnachicht*/
select *
from bewerber
where bewerberid = /bewerberid/;