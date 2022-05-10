USE TurystykaBazaDanych
go

INSERT INTO 
	Turysta(Imie, Nazwisko) VALUES
		('Marek', 'Nazwisko1'),
		('Jan', 'Nazwisko2'),
		('Pawel', 'Nazwisko3'),
		('Michal', 'Nazwisko4'),
		('Karolina', 'Nazwisko5'),
		('Beny', 'Nazwisko6'),
		('Janusz', 'Nazwisko7'),
		('Kuba', 'Nazwisko8')

INSERT INTO --- FORMAT PODAWANIA DATY MM-DD-RRRR !!!!!!!!
	Przewodnik(PESEL, Imie, Nazwisko, Data_rozpoczecia_pracy) VALUES
		('11111111111', 'Imie1', 'Nazwisko771', '01.01.2000'),
		('11111111112', 'Imie2', 'Nazwisko772', '01.02.2000'),
		('11111111113', 'Imie3', 'Nazwisko773', '01.03.2000')

INSERT INTO  --- FORMAT PODAWANIA DATY MM-DD-RRRR !!!!!!!!
	TerminarzPrzewodnikow(PESEL_przewodnika, Data_rozpoczecia, Data_zakonczenia) VALUES
		('11111111111', '02.02.2022', '02.04.2022'),
		('11111111111', '02.06.2022', '02.12.2022'),
		('11111111112', '03.17.2022', '03.25.2022'),
		('11111111113', '02.02.2022', '02.05.2022'),
		('11111111113', '02.21.2022', '02.22.2022')

INSERT INTO
	OpiniaPrzewodnika(PESEL_przewodnika, Ocena, Opis) VALUES
		('11111111111', 9, 'bardzo dobry pracownik'),
		('11111111111', 5, 'dobry pracownik'),
		('11111111111', 1, 'niemi³y pracownik'),
		('11111111112', 10, NULL),
		('11111111112', 6, 'giga koks')

INSERT INTO
	Grupa(PESEL_przewodnika) VALUES
		('11111111111'),
		('11111111111'),
		('11111111112'),
		('11111111113')

INSERT INTO 
	PrzynaleznoscDoGrupy(ID_Grupy, ID_Turysty) VALUES
		(1,1), (1,2), (1,5), (1,8),    --taki zapis oznacza ¿e w 1 grupie bêda klienci o id 1,2,5,8
		(2,2), (2,3), (2,7),		   --analogicznie w 2 grupie bêda klienci o id 2,3,7
		(3,1), (3,2), (3,3), (3,4), (3,5), (3,6)

INSERT INTO --- FORMAT PODAWANIA DATY MM-DD-RRRR !!!!!!!!
	Wycieczka(Data_rozpoczecia, Data_zakonczenia, Cena_biletu, Miejsce_wycieczki) VALUES
		('01.10.2019', '01.20.2019', 2000, 'Jablonowo'),
		('02.02.2019', '02.07.2019', 4999, 'Brodnica'),
		('05.01.2019', '05.03.2019', 600, 'Bobrowo')

INSERT INTO
	PrzeprowadzanieWycieczki(ID_Wycieczki, ID_Grupy) VALUES
		(1, 1), (1,2),			-- oznacza ¿e na 1 wycieczce by³a 1 i 2 grupa
		(2,2),
		(3,1), (3,2), (3,3)