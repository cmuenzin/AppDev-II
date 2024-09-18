/*bewerbung erstellen*/
insert into 'bewerbung' (
    bewerbungsid,
    bewerberid,
    datum,
    bewerbungsdaten,
    status
)
Values (
    /bewerbungsid/,
    /bewerberid/,
    /datum/,
    /bewerbungsdaten/,
    /status/
)


/*bewerbungsstatus_annehmen*/
update bewerbung
set status = 'angenommen'
where bewerbungsid = /bewerbungsid/


select (count(terminid as 'Anzahl_Empfehlungen' )
    from termin join bewerbung on bewerbung.bewerberid = termin.bewerberid
    where bewerberid = /bewerberid/ and termin.empfehlung = 'true'