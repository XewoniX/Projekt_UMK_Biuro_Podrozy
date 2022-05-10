USE TurystykaBazaDanych
go

CREATE TABLE Przewodnik(
	PESEL varchar(11) PRIMARY KEY,
	Imie varchar(50) NOT NULL,
	Nazwisko varchar(50) NOT NULL,
	Data_rozpoczecia_pracy date
)

CREATE TABLE TerminarzPrzewodnikow(
	ID_Terminu INT IDENTITY(1,1) PRIMARY KEY,
	PESEL_przewodnika varchar(11) FOREIGN KEY REFERENCES Przewodnik(PESEL) ON DELETE CASCADE,
	Data_rozpoczecia date NOT NULL,
	Data_zakonczenia date NOT NULL,
	CHECK (DATEDIFF(day, Data_rozpoczecia, Data_zakonczenia) >= 0)
)

CREATE TABLE OpiniaPrzewodnika(
	ID_Opinii INT IDENTITY(1,1) PRIMARY KEY,
	PESEL_przewodnika varchar(11) FOREIGN KEY REFERENCES Przewodnik(PESEL) ON DELETE CASCADE,
	Ocena INT NOT NULL CHECK (Ocena >= 0 AND Ocena <= 10),  --przyjmuje skale ocen od 0 do 10 "gwiazdek"
	Opis varchar(500)
)

CREATE TABLE Turysta (
	ID_Turysty INT IDENTITY(1,1) PRIMARY KEY,
	Imie varchar(50),
	Nazwisko varchar(50),
	Email varchar(50) CHECK (Email LIKE '%_@__%.__%')
)

CREATE TABLE Grupa (
	ID_Grupy INT IDENTITY(1,1) PRIMARY KEY,
	PESEL_przewodnika varchar(11) FOREIGN KEY REFERENCES Przewodnik(PESEL) ON DELETE CASCADE
)

CREATE TABLE PrzynaleznoscDoGrupy (
	ID_Grupy INT FOREIGN KEY REFERENCES Grupa(ID_Grupy) ON DELETE CASCADE,
	ID_Turysty INT FOREIGN KEY REFERENCES Turysta(ID_Turysty) ON DELETE CASCADE
)

CREATE TABLE Wycieczka(
	ID_Wycieczki INT IDENTITY(1,1) PRIMARY KEY,
	Data_rozpoczecia date NOT NULL,
	Data_zakonczenia date NOT NULL,
	Cena_biletu INT NOT NULL CHECK (Cena_biletu >= 0),
	Miejsce_wycieczki varchar(50),
	CHECK (DATEDIFF(day, Data_rozpoczecia, Data_zakonczenia) >= 0)
)

CREATE TABLE PrzeprowadzanieWycieczki(
	ID_Grupy INT FOREIGN KEY REFERENCES Grupa(ID_Grupy) ON DELETE CASCADE,
	ID_Wycieczki INT FOREIGN KEY REFERENCES Wycieczka(ID_Wycieczki) ON DELETE CASCADE,
)