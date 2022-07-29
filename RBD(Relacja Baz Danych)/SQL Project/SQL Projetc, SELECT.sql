--1.Wybrac pracownikow z pencja > 2500
select imie , nazwisko, pensja from pracownik
where pensja > 2500;
--2.wybrac pracownikow zatrudnionych po 01.01.1999 roku
select imie , nazwisko, data_zatrudnienia from pracownik
where data_zatrudnienia > '01.01.1999';
--3.wybrac pracownikow imiona ktoruch zaczyna sie na "A"
select imie, nazwisko, pensja from pracownik
where imie like 'A%';
--4.wybrac pokoje na 2 pietrze
select numer_pokoju, kategoria_pokoju_id_kategoria from pokoj
where pietro = 2;
--5.wybrac pokoje ktore zaczynaja sprzatac o 12:00
select pokoj_id_pokoju,CZAS_POCZATKU_SPRZATANIA from grafika_sprzatania_pokoju
where extract(hour from CZAS_POCZATKU_SPRZATANIA) = 12;
--6.wyswietlic imiona pracownikow ktory sprzataja pokoje
select imie  from grafika_sprzatania_pokoju
inner join pracownik on id_pracownika = pracownik_id_pracownika 
group by imie;
--7.wyswietlic wszystka informacje na temat goscia i go rezerwacji
select * from gosc 
inner join rezerwacja_pokoju on id_goscia = gosc_id_goscia;
--8.wyswietlic nazwiska i date rezerwacji gosci ktorych przyjmowal Sergej
select gosc.imie, gosc.nazwisko, data_rezerwacji from pracownik
inner join rezerwacja_pokoju on id_pracownika = pracownik_id_pracownika 
inner join gosc on id_goscia = gosc_id_goscia
where pracownik.imie like 'Sergej%';
--9.wyswietlic informacje o gosciach ktorzy mieszkali na 2 pietrze
select imie , nazwisko from rezerwacja_pokoju
inner join gosc on id_goscia = gosc_id_goscia
inner join pokoj on POKOJ_ID_POKOJU = ID_POKOJU
where pietro = 2;
--10.wyswietlic informacje o sprzataniu pokoje na 1 pietrze
select NUMER_POKOJU, czas_poczatku_sprzatania , czas_skonczenia_sprzatania from grafika_sprzatania_pokoju
inner join pokoj on id_pokoju = POKOJ_ID_POKOJU
where pietro = 1;
--00.wyswietlic najwyzsza pensje
select imie,pensja from pracownik
where pensja = (select max(pensja) from pracownik);
--11.wyswietlic ile razy mieszkali w kazdym pokoje
select numer_pokoju , count(POKOJ_ID_POKOJU)from pokoj
inner join REZERWACJA_POKOJU on id_pokoju = POKOJ_ID_POKOJU
group by numer_pokoju;
--12.wyswietlic imie pracownikow ktorzy sprzataja wiecej niz 1 pokoj
select imie from GRAFIKA_SPRZATANIA_POKOJU
inner join pracownik on PRACOWNIK_ID_PRACOWNIKA = id_pracownika
group by imie
having count(PRACOWNIK_ID_PRACOWNIKA) > 1;
--13.wyswietlic ile razy kazdy pracownik rezerwowal goscia do hotelu
select imie ,count(PRACOWNIK_ID_PRACOWNIKA) from REZERWACJA_POKOJU
inner join pracownik on PRACOWNIK_ID_PRACOWNIKA = id_pracownika
group by imie;
--14.wyswitlic srednie pensje zatrudnionych w kazdym roku
select to_char(DATA_ZATRUDNIENIA, 'yyyy') as "year", avg(pensja) from pracownik
group by to_char(DATA_ZATRUDNIENIA, 'yyyy');
--15.wyswieltlic ile bylo zrobione rezerwacje kazdy rok
select to_char(DATA_REZERWACJI, 'yyyy'), count(DATA_REZERWACJI) from REZERWACJA_POKOJU
group by to_char(DATA_REZERWACJI, 'yyyy');
--16.wyswietlic nazwiska pracownikow ktory sprzataja pokoje
select nazwisko  from grafika_sprzatania_pokoju
inner join pracownik on id_pracownika = pracownik_id_pracownika 
group by nazwisko;
--17.wyswietlic gosci ktorzy rezerwowali pokoj wiecej niz 1 raz
select imie, nazwisko,count(gosc_id_goscia) from REZERWACJA_POKOJU
inner join gosc on id_goscia = gosc_id_goscia
group by imie,nazwisko
having count(gosc_id_goscia) > 1;