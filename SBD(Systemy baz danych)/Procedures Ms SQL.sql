exec proc1 2000;
select * from pracownik;
select * from Grafika_sprzatania_pokoju;
select * from pokoj;
select * from Kategoria_Pokoju;
select * from Gosc;
select * from Rezerwacja_pokoju;
--wypisuje informacje o pracownikach zatrudnionnych w podannym roku
go
create procedure Procedure1
(@rok int)
as
begin
select imie , nazwisko , pensja 
from Pracownik
where year(Pracownik.Data_zatrudnienia) = @rok;
end;

exec Procedure1 2000;
drop procedure Procedure1;

--wypisuje informacje grafiku sprzatan pracownikow z pensja powyzej podanej w argumencie
go
create procedure Procudure2
(@IlePensja int)
as
declare curc cursor for
	select Imie ,Nazwisko , Pensja, Pokoj_ID_pokoju, Czas_poczatku_sprzatania
	from Grafika_sprzatania_pokoju
	join Pracownik on Pracownik.ID_pracownika = Grafika_sprzatania_pokoju.Pracownik_ID_pracownika;
declare @imie char(30);
declare @nazwisko char(30);
declare @pensja integer;
declare @pokoj int;
declare @czas time(0);
declare @info varchar(128);
OPEN curc
   FETCH NEXT FROM curc INTO @imie, @nazwisko,@pensja,@pokoj,@czas
   WHILE @@FETCH_STATUS = 0
begin
	if @pensja > @IlePensja
	begin
	set @info = @imie + @nazwisko+ ' sprzata pokoj numer: ' + cast(@pokoj as char(2)) + ' o '+ cast(@czas as char(10));
	print(@info);
	end;
	FETCH NEXT FROM curc INTO @imie, @nazwisko,@pensja,@pokoj,@czas
end
CLOSE curc
DEALLOCATE curc

exec Procudure2 2000;
drop procedure Procudure2;