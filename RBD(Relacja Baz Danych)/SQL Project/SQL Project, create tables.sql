-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2020-06-17 14:08:09.392

-- tables
-- Table: Gosc
CREATE TABLE Gosc (
    ID_goscia int  NOT NULL,
    Imie char(30)  NOT NULL,
    Nazwisko char(30)  NOT NULL,
    CONSTRAINT Gosc_pk PRIMARY KEY (ID_goscia)
) ;

-- Table: Grafika_sprzatania_pokoju
CREATE TABLE Grafika_sprzatania_pokoju (
    Pracownik_ID_pracownika int  NOT NULL,
    Pokoj_ID_pokoju integer  NOT NULL,
    Czas_poczatku_sprzatania timestamp  NOT NULL,
    Czas_skonczenia_sprzatania timestamp  NOT NULL,
    CONSTRAINT Grafika_sprzatania_pokoju_pk PRIMARY KEY (Pracownik_ID_pracownika,Pokoj_ID_pokoju,Czas_poczatku_sprzatania)
) ;

-- Table: Kategoria_Pokoju
CREATE TABLE Kategoria_Pokoju (
    Id_kategoria integer  NOT NULL,
    Nazwa_Kategorie char(20)  NOT NULL,
    Cena_Pokoju number(6,2)  NOT NULL,
    CONSTRAINT Kategoria_Pokoju_pk PRIMARY KEY (Id_kategoria)
) ;

-- Table: Pokoj
CREATE TABLE Pokoj (
    ID_pokoju integer  NOT NULL,
    Pietro integer  NOT NULL,
    Numer_pokoju integer  NOT NULL,
    Kategoria_Pokoju_Id_kategoria integer  NOT NULL,
    CONSTRAINT Pokoj_pk PRIMARY KEY (ID_pokoju)
) ;

-- Table: Pracownik
CREATE TABLE Pracownik (
    ID_pracownika int  NOT NULL,
    Imie char(30)  NOT NULL,
    Nazwisko char(30)  NOT NULL,
    Data_zatrudnienia date  NOT NULL,
    Pensja integer  NOT NULL,
    CONSTRAINT Pracownik_pk PRIMARY KEY (ID_pracownika)
) ;

-- Table: Rezerwacja_pokoju
CREATE TABLE Rezerwacja_pokoju (
    Pracownik_ID_pracownika int  NOT NULL,
    Gosc_ID_goscia integer  NOT NULL,
    Data_rezerwacji date  NOT NULL,
    Pokoj_ID_pokoju integer  NOT NULL,
    Data_przyjazdu date  NOT NULL,
    Data_odjazdu date  NOT NULL,
    CONSTRAINT Rezerwacja_pokoju_pk PRIMARY KEY (Pracownik_ID_pracownika,Gosc_ID_goscia,Data_rezerwacji)
) ;

-- foreign keys
-- Reference: Pokoj_Kategoria_Pokoju (table: Pokoj)
ALTER TABLE Pokoj ADD CONSTRAINT Pokoj_Kategoria_Pokoju
    FOREIGN KEY (Kategoria_Pokoju_Id_kategoria)
    REFERENCES Kategoria_Pokoju (Id_kategoria);

-- Reference: Rezerwacja_Pracownik (table: Rezerwacja_pokoju)
ALTER TABLE Rezerwacja_pokoju ADD CONSTRAINT Rezerwacja_Pracownik
    FOREIGN KEY (Pracownik_ID_pracownika)
    REFERENCES Pracownik (ID_pracownika);

-- Reference: Rezerwacja_pokoju_Gosc (table: Rezerwacja_pokoju)
ALTER TABLE Rezerwacja_pokoju ADD CONSTRAINT Rezerwacja_pokoju_Gosc
    FOREIGN KEY (Gosc_ID_goscia)
    REFERENCES Gosc (ID_goscia);

-- Reference: Rezerwacja_pokoju_Pokoj (table: Rezerwacja_pokoju)
ALTER TABLE Rezerwacja_pokoju ADD CONSTRAINT Rezerwacja_pokoju_Pokoj
    FOREIGN KEY (Pokoj_ID_pokoju)
    REFERENCES Pokoj (ID_pokoju);

-- Reference: Sprzatania_Pokoj (table: Grafika_sprzatania_pokoju)
ALTER TABLE Grafika_sprzatania_pokoju ADD CONSTRAINT Sprzatania_Pokoj
    FOREIGN KEY (Pokoj_ID_pokoju)
    REFERENCES Pokoj (ID_pokoju);

-- Reference: Sprzatania_Pracownik (table: Grafika_sprzatania_pokoju)
ALTER TABLE Grafika_sprzatania_pokoju ADD CONSTRAINT Sprzatania_Pracownik
    FOREIGN KEY (Pracownik_ID_pracownika)
    REFERENCES Pracownik (ID_pracownika);

-- End of file.

