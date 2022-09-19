
CREATE TABLE Przewodnik(
	PESEL varchar(11) PRIMARY KEY,
	Imie varchar(50) NOT NULL,
	Nazwisko varchar(50) NOT NULL,
	Data_rozpoczecia_pracy date
);

CREATE TABLE TerminarzPrzewodnikow(
	ID_Terminu INT AUTO_INCREMENT PRIMARY KEY,
	PESEL_przewodnika varchar(11),
	Data_rozpoczecia date NOT NULL,
	Data_zakonczenia date NOT NULL,
    FOREIGN KEY (PESEL_przewodnika) REFERENCES Przewodnik(PESEL) ON DELETE CASCADE,
	CHECK (DATEDIFF(Data_zakonczenia, Data_rozpoczecia) >= 0)
);

CREATE TABLE OpiniaPrzewodnika(
	ID_Opinii INT AUTO_INCREMENT PRIMARY KEY,
	PESEL_przewodnika varchar(11),
	Ocena INT NOT NULL CHECK (Ocena >= 0 AND Ocena <= 10),
	Opis varchar(500),
	FOREIGN KEY (PESEL_przewodnika) REFERENCES Przewodnik(PESEL) ON DELETE CASCADE
);

CREATE TABLE Turysta (
	ID_Turysty INT AUTO_INCREMENT PRIMARY KEY,
	Imie varchar(50),
	Nazwisko varchar(50),
	Email varchar(50) CHECK (Email LIKE '%_@__%.__%')
);

CREATE TABLE Grupa (
	ID_Grupy INT AUTO_INCREMENT PRIMARY KEY,
	PESEL_przewodnika varchar(11),
	FOREIGN KEY (PESEL_przewodnika) REFERENCES Przewodnik(PESEL) ON DELETE CASCADE
);

CREATE TABLE PrzynaleznoscDoGrupy (
	ID_Grupy INT,
	ID_Turysty INT,
	FOREIGN KEY (ID_Grupy) REFERENCES Grupa(ID_Grupy) ON DELETE CASCADE,
	FOREIGN KEY (ID_Turysty) REFERENCES Turysta(ID_Turysty) ON DELETE CASCADE
);

CREATE TABLE Wycieczka(
	ID_Wycieczki INT AUTO_INCREMENT PRIMARY KEY,
	Data_rozpoczecia date NOT NULL,
	Data_zakonczenia date NOT NULL,
	Cena_biletu INT NOT NULL CHECK (Cena_biletu >= 0),
	Miejsce_wycieczki varchar(50),
	CHECK (TIMESTAMPDIFF(day, Data_rozpoczecia, Data_zakonczenia) >= 0)
);

CREATE TABLE PrzeprowadzanieWycieczki(
	ID_Grupy INT,
	ID_Wycieczki INT,
	FOREIGN KEY (ID_Grupy) REFERENCES Grupa(ID_Grupy) ON DELETE CASCADE,
	FOREIGN KEY (ID_Wycieczki) REFERENCES Wycieczka(ID_Wycieczki) ON DELETE CASCADE
);