USE TurystykaBazaDanych
go

-- view maj¹cy w sobie pesel przewodnika, jego imie i naziwisko oraz œrêdni¹ ocene
If (object_id('PrzewodnikZOcenami') is not null) 
	DROP VIEW PrzewodnikZOcenami;
go

CREATE VIEW PrzewodnikZOcenami
AS
SELECT PESEL, Imie, Nazwisko, AVG(Ocena) AS 'Œrednia ocena'  FROM Przewodnik
JOIN OpiniaPrzewodnika ON OpiniaPrzewodnika.PESEL_przewodnika = Przewodnik.PESEL 
GROUP BY PESEL, Imie, Nazwisko

go

-- view maj¹cy w sobie id grupy oraz iloœæ osob w tej grupie
If (object_id('GrupyIloscOsob') is not null) 
	DROP VIEW GrupyIloscOsob;
go

CREATE VIEW GrupyIloscOsob
AS
SELECT Grupa.ID_Grupy, COUNT(PrzynaleznoscDoGrupy.ID_Grupy) as 'Iloœæ osób w grupie' FROM Grupa
JOIN PrzynaleznoscDoGrupy ON PrzynaleznoscDoGrupy.ID_Grupy = Grupa.ID_Grupy
GROUP BY Grupa.ID_Grupy

go

-- view maj¹cy w sobie id turysty, jego imie i nazwisko oraz wszystkie wycieczki na ktorych byl razem z celem podrozy (po id wycieczek)
If (object_id('TurystaIWycieczki') is not null) 
	DROP VIEW TurystaIWycieczki;
go

CREATE VIEW TurystaIWycieczki
AS
SELECT DISTINCT Turysta.Imie, Turysta.Nazwisko,Turysta.ID_Turysty, Wycieczka.ID_Wycieczki, Miejsce_wycieczki FROM Turysta
JOIN PrzynaleznoscDoGrupy ON PrzynaleznoscDoGrupy.ID_Turysty = Turysta.ID_Turysty
JOIN Grupa ON PrzynaleznoscDoGrupy.ID_Grupy = Grupa.ID_Grupy
JOIN PrzeprowadzanieWycieczki ON PrzeprowadzanieWycieczki.ID_Grupy = Grupa.ID_Grupy
JOIN Wycieczka ON Wycieczka.ID_Wycieczki = PrzeprowadzanieWycieczki.ID_Wycieczki

go

-- view majacy w sobie ³¹czny zarobek z danej wycieczki
If (object_id('WycieczkaZarobek') is not null) 
	DROP VIEW WycieczkaZarobek;
go

CREATE VIEW WycieczkaZarobek
AS 
SELECT ID_Wycieczki, COUNT(ILOSC)*Cena_biletu as 'Przychód' FROM (
	SELECT DISTINCT Cena_biletu, Wycieczka.ID_Wycieczki, PrzynaleznoscDoGrupy.ID_Turysty AS ILOSC FROM Wycieczka
	JOIN PrzeprowadzanieWycieczki ON PrzeprowadzanieWycieczki.ID_Wycieczki = Wycieczka.ID_Wycieczki
	JOIN Grupa ON Grupa.ID_Grupy = PrzeprowadzanieWycieczki.ID_Grupy
	JOIN PrzynaleznoscDoGrupy ON PrzynaleznoscDoGrupy.ID_Grupy = Grupa.ID_Grupy) AS x
GROUP BY ID_Wycieczki, Cena_biletu

go

-- view maj¹cy id grupy i informacje o jej przewodniku
If (object_id('GrupaZPrzewodnikiem') is not null) 
	DROP VIEW GrupaZPrzewodnikiem;
go

CREATE VIEW GrupaZPrzewodnikiem
AS
SELECT ID_Grupy, Pesel, Imie, Nazwisko FROM Grupa
JOIN Przewodnik ON Przewodnik.PESEL = Grupa.PESEL_przewodnika
go

-- view zawieraj¹cy id wycieczki, ilosc dni tej wycieczki, cena za closc i œredni¹ cene za 1 dzien wycieczki
If (object_id('WycieczkaDniSredniaCena') is not null) 
	DROP VIEW WycieczkaDniSredniaCena;
go

CREATE VIEW WycieczkaDniSredniaCena
AS
SELECT ID_Wycieczki, 
	   DATEDIFF(day, Data_rozpoczecia, Data_zakonczenia) AS 'Iloœæ dni',
	   Cena_biletu,
	   Cena_biletu / DATEDIFF(day, Data_rozpoczecia, Data_zakonczenia) as 'Œrednia cena za 1 dzieñ' 
FROM Wycieczka





