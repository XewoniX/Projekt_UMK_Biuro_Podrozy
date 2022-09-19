INSERT INTO
	Turysta(Imie, Nazwisko, Email) VALUES
		('Marek', 'Nazwisko1', 'MarekJakis@gmail.com'),
		('Jan', 'Nazwisko2', 'JanJakis@gmail.com'),
		('Pawel', 'Nazwisko3', 'PawelJakis@gmail.com'),
		('Michal', 'Nazwisko4', 'MichalJakis@gmail.com'),
		('Karolina', 'Nazwisko5', 'KarolinaJakis@gmail.com'),
		('Beny', 'Nazwisko6', 'BenJakis@gmail.com'),
		('Janusz', 'Nazwisko7', 'JanuszJakis@gmail.com'),
		('Kuba', 'Nazwisko8', 'KubusJakis@gmail.com');

INSERT INTO
	Przewodnik(PESEL, Imie, Nazwisko, Data_rozpoczecia_pracy) VALUES
		('11111111111', 'Imie1', 'Nazwisko771', '2000-01-01'),
		('11111111112', 'Imie2', 'Nazwisko772', '2000-02-01'),
		('11111111113', 'Imie3', 'Nazwisko773', '2000-03-01');

INSERT INTO
	TerminarzPrzewodnikow(PESEL_przewodnika, Data_rozpoczecia, Data_zakonczenia) VALUES
		('11111111111', '2022.02.03', '2022.02.04'),
		('11111111111', '2022.02.06', '2022.02.12'),
		('11111111112', '2022.03.17', '2022.03.25'),
		('11111111113', '2022.02.02', '2022.02.05'),
		('11111111113', '2022.02.21', '2022.02.22');

INSERT INTO
	OpiniaPrzewodnika(PESEL_przewodnika, Ocena, Opis) VALUES
		('11111111111', 9, 'bardzo dobry pracownik'),
		('11111111111', 5, 'dobry pracownik'),
		('11111111111', 1, 'niemi³y pracownik'),
		('11111111112', 10, NULL),
		('11111111112', 6, 'giga koks');

INSERT INTO
	Grupa(PESEL_przewodnika) VALUES
		('11111111111'),
		('11111111111'),
		('11111111112'),
		('11111111113');

INSERT INTO 
	PrzynaleznoscDoGrupy(ID_Grupy, ID_Turysty) VALUES
		(1,1), (1,2), (1,5), (1,8),    -- taki zapis oznacza ¿e w 1 grupie bêda klienci o id 1,2,5,8
		(2,2), (2,3), (2,7),		   -- analogicznie w 2 grupie bêda klienci o id 2,3,7
		(3,1), (3,2), (3,3), (3,4), (3,5), (3,6);

INSERT INTO
	Wycieczka(Data_rozpoczecia, Data_zakonczenia, Cena_biletu, Miejsce_wycieczki) VALUES
		('2019.01.10', '2019.01.20', 2000, 'Jablonowo'),
		('2019.02.02', '2019.02.07', 4999, 'Brodnica'),
		('2019.05.01', '2019.05.03', 600, 'Bobrowo');

INSERT INTO
	PrzeprowadzanieWycieczki(ID_Wycieczki, ID_Grupy) VALUES
		(1, 1), (1,2),			-- oznacza ¿e na 1 wycieczce by³a 1 i 2 grupa
		(2,2),
		(3,1), (3,2), (3,3);