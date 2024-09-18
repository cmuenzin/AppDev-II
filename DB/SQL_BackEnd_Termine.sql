/*TerminEinladung_Senden*/
insert into Termin (
    bewerberid,
    mitarbeiterid,
    datum
)
values (
   
    bewerberid,
    mitarbeiterid,
    datum
);


/*TerminEinladung_Ablehnen*/
update Termin
set bestätigt = `false`
where terminid = terminid;


/*TerminEinladung_Annehmen*/
update Termin
set bestätigt = `true`
where terminid = terminid;


/*BewerberErscheint_Nicht*/
update Termin
set erschienen = `false`
where terminid = terminid;


/*BewerberErscheint*/
update Termin
set erschienen = `true`
where terminid = terminid;


/*BewertungBewerber*/
update Termin
set bewertung = /Bewertung/
where terminid = terminid;


/*BewertungBewerber*/
update Termin
set empfehlung = /empfehlung/ boolean
where terminid = terminid;


/*ZweitTerminBedingung*/
select distinct count(terminid)
from termin 
where bewerberid = /bewerberid/ and empfehlung = 'true'

select distinct count(terminid)
from termin
where bewerberid = /bewerberid/ and empfehlung = 'false'

/*ZweitTerminBedingung*/
select distinct count(terminid)
from termin 
where bewerberid = /bewerberid/ and empfehlung = 'true'