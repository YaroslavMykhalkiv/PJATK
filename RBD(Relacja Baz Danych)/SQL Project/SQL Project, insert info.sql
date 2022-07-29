insert into Pracownik (id_pracownika,imie,nazwisko,data_zatrudnienia,pensja) values (1,'Vlad','Romanko','13.10.2000',3000);
insert into Pracownik (id_pracownika,imie,nazwisko,data_zatrudnienia,pensja) values (2,'Sergej','Petuch','24.05.1998',1800);
insert into Pracownik (id_pracownika,imie,nazwisko,data_zatrudnienia,pensja) values (3,'Asya','Gryb','22.06.1997',3500);
insert into Pracownik (id_pracownika,imie,nazwisko,data_zatrudnienia,pensja) values (4,'Mateusz','Honczar','11.03.1999',2000);
insert into Pracownik (id_pracownika,imie,nazwisko,data_zatrudnienia,pensja) values (5,'Anton','Katyrenczuk','09.02.2000',3300);
insert into Pracownik (id_pracownika,imie,nazwisko,data_zatrudnienia,pensja) values (6,'Vika','Tulieva','10.03.1995',1900);
insert into Pracownik (id_pracownika,imie,nazwisko,data_zatrudnienia,pensja) values (7,'Sasza','Kakasza','14.07.1990',2500);

insert into Grafika_sprzatania_pokoju (Pracownik_ID_pracownika,Pokoj_ID_pokoju,Czas_poczatku_sprzatania,Czas_skonczenia_sprzatania) values (3,2,'22-06-1997 12:00:00','22-06-1997 13:00:00');
insert into Grafika_sprzatania_pokoju (Pracownik_ID_pracownika,Pokoj_ID_pokoju,Czas_poczatku_sprzatania,Czas_skonczenia_sprzatania) values (3,8,'22-06-1997 14:00:00','22-06-1997 15:00:00');
insert into Grafika_sprzatania_pokoju (Pracownik_ID_pracownika,Pokoj_ID_pokoju,Czas_poczatku_sprzatania,Czas_skonczenia_sprzatania) values (5,1,'22-06-1997 12:00','22-06-1997 13:00');
insert into Grafika_sprzatania_pokoju (Pracownik_ID_pracownika,Pokoj_ID_pokoju,Czas_poczatku_sprzatania,Czas_skonczenia_sprzatania) values (5,7,'22-06-1997 14:00:00','22-06-1997 15:00:00');
insert into Grafika_sprzatania_pokoju (Pracownik_ID_pracownika,Pokoj_ID_pokoju,Czas_poczatku_sprzatania,Czas_skonczenia_sprzatania) values (4,6,'22-06-1997 12:00:00','22-06-1997 13:00:00');
insert into Grafika_sprzatania_pokoju (Pracownik_ID_pracownika,Pokoj_ID_pokoju,Czas_poczatku_sprzatania,Czas_skonczenia_sprzatania) values (6,3,'22-06-1997 12:00:00','22-06-1997 13:00:00');
insert into Grafika_sprzatania_pokoju (Pracownik_ID_pracownika,Pokoj_ID_pokoju,Czas_poczatku_sprzatania,Czas_skonczenia_sprzatania) values (7,4,'22-06-1997 12:00:00','22-06-1997 13:00:00');
insert into Grafika_sprzatania_pokoju (Pracownik_ID_pracownika,Pokoj_ID_pokoju,Czas_poczatku_sprzatania,Czas_skonczenia_sprzatania) values (7,5,'22-06-1997 14:00:00','22-06-1997 15:00:00');

update Grafika_sprzatania_pokoju set Czas_poczatku_sprzatania = '01-01-01 12:00:00' , Czas_skonczenia_sprzatania = '01-01-01 13:00:00' 
where Pokoj_ID_pokoju = 2 or Pokoj_ID_pokoju = 1 or Pokoj_ID_pokoju = 6 or Pokoj_ID_pokoju = 3 or Pokoj_ID_pokoju = 4 ;

update Grafika_sprzatania_pokoju set Czas_poczatku_sprzatania = '01-01-01 14:00:00' , Czas_skonczenia_sprzatania = '01-01-01 15:00:00' 
where Pokoj_ID_pokoju = 5 or Pokoj_ID_pokoju = 8 or Pokoj_ID_pokoju = 7;

insert into Pokoj (ID_pokoju,Pietro,Numer_pokoju,Kategoria_Pokoju_Id_kategoria) values (1,1,11,1);
insert into Pokoj (ID_pokoju,Pietro,Numer_pokoju,Kategoria_Pokoju_Id_kategoria) values (2,1,12,1);
insert into Pokoj (ID_pokoju,Pietro,Numer_pokoju,Kategoria_Pokoju_Id_kategoria) values (3,1,13,1);
insert into Pokoj (ID_pokoju,Pietro,Numer_pokoju,Kategoria_Pokoju_Id_kategoria) values (4,1,14,1);
insert into Pokoj (ID_pokoju,Pietro,Numer_pokoju,Kategoria_Pokoju_Id_kategoria) values (5,2,21,2);
insert into Pokoj (ID_pokoju,Pietro,Numer_pokoju,Kategoria_Pokoju_Id_kategoria) values (6,2,22,2);
insert into Pokoj (ID_pokoju,Pietro,Numer_pokoju,Kategoria_Pokoju_Id_kategoria) values (7,2,23,2);
insert into Pokoj (ID_pokoju,Pietro,Numer_pokoju,Kategoria_Pokoju_Id_kategoria) values (8,2,24,2);

insert into Kategoria_Pokoju (Id_kategoria,Nazwa_Kategorie,Cena_Pokoju) values (1,'Ekonom',150);
insert into Kategoria_Pokoju (Id_kategoria,Nazwa_Kategorie,Cena_Pokoju) values (2,'Sredni',300);

insert into Gosc(ID_goscia,Imie,nazwisko) values (1,'Sasza','Luser');
insert into Gosc(ID_goscia,Imie,nazwisko) values (2,'Vanya','Kolobok');
insert into Gosc(ID_goscia,Imie,nazwisko) values (3,'Kolya','Nester');
insert into Gosc(ID_goscia,Imie,nazwisko) values (4,'Nikita','Kulin');
insert into Gosc(ID_goscia,Imie,nazwisko) values (5,'Gleb','Oczka');
insert into Gosc(ID_goscia,Imie,nazwisko) values (6,'Diana','Mididnskaya');
insert into Gosc(ID_goscia,Imie,nazwisko) values (7,'Bogdan','Baklan');
insert into Gosc(ID_goscia,Imie,nazwisko) values (8,'Yaroslav','Mykhalkiv');

insert into Rezerwacja_pokoju(Pracownik_ID_pracownika,Gosc_ID_goscia,Data_rezerwacji,Pokoj_ID_pokoju,Data_przyjazdu,Data_odjazdu) values (1,1,'01.01.2002',1,'05.01.2002','15.01.2002');
insert into Rezerwacja_pokoju(Pracownik_ID_pracownika,Gosc_ID_goscia,Data_rezerwacji,Pokoj_ID_pokoju,Data_przyjazdu,Data_odjazdu) values (1,1,'01.01.2003',1,'05.01.2003','15.01.2003');
insert into Rezerwacja_pokoju(Pracownik_ID_pracownika,Gosc_ID_goscia,Data_rezerwacji,Pokoj_ID_pokoju,Data_przyjazdu,Data_odjazdu) values (1,2,'01.02.2002',2,'01.02.2002','20.02.2002');
insert into Rezerwacja_pokoju(Pracownik_ID_pracownika,Gosc_ID_goscia,Data_rezerwacji,Pokoj_ID_pokoju,Data_przyjazdu,Data_odjazdu) values (1,3,'01.03.2003',3,'01.03.2003','05.03.2003');
insert into Rezerwacja_pokoju(Pracownik_ID_pracownika,Gosc_ID_goscia,Data_rezerwacji,Pokoj_ID_pokoju,Data_przyjazdu,Data_odjazdu) values (1,4,'01.04.2002',3,'05.07.2002','10.07.2002');
insert into Rezerwacja_pokoju(Pracownik_ID_pracownika,Gosc_ID_goscia,Data_rezerwacji,Pokoj_ID_pokoju,Data_przyjazdu,Data_odjazdu) values (1,5,'01.05.2002',4,'01.05.2002','14.05.2002');
insert into Rezerwacja_pokoju(Pracownik_ID_pracownika,Gosc_ID_goscia,Data_rezerwacji,Pokoj_ID_pokoju,Data_przyjazdu,Data_odjazdu) values (2,6,'01.06.2003',5,'01.06.2003','29.06.2003');
insert into Rezerwacja_pokoju(Pracownik_ID_pracownika,Gosc_ID_goscia,Data_rezerwacji,Pokoj_ID_pokoju,Data_przyjazdu,Data_odjazdu) values (2,7,'01.07.2002',6,'05.07.2002','05.08.2002');
insert into Rezerwacja_pokoju(Pracownik_ID_pracownika,Gosc_ID_goscia,Data_rezerwacji,Pokoj_ID_pokoju,Data_przyjazdu,Data_odjazdu) values (2,8,'01.08.2002',7,'01.08.2002','24.08.2002');

select * from pracownik;
select * from Grafika_sprzatania_pokoju;
select * from pokoj;
select * from Kategoria_Pokoju;
select * from Gosc;
select * from Rezerwacja_pokoju;