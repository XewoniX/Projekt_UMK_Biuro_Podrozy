
-- view maj�cy w sobie pesel przewodnika, jego imie i naziwisko oraz �r�dni� ocene
CREATE VIEW PrzewodnikZOcenami
AS
SELECT PESEL, Imie, Nazwisko, AVG(Ocena) AS '�rednia ocena'  FROM Przewodnik
JOIN OpiniaPrzewodnika ON OpiniaPrzewodnika.PESEL_przewodnika = Przewodnik.PESEL 
GROUP BY PESEL, Imie, Nazwisko;

-- view maj�cy w sobie id grupy oraz ilo�� osob w tej grupie
CREATE VIEW GrupyIloscOsob
AS
SELECT Grupa.ID_Grupy, COUNT(PrzynaleznoscDoGrupy.ID_Grupy) as 'Ilo�� os�b w grupie' FROM Grupa
JOIN PrzynaleznoscDoGrupy ON PrzynaleznoscDoGrupy.ID_Grupy = Grupa.ID_Grupy
GROUP BY Grupa.ID_Grupy;

-- view maj�cy w sobie id turysty, jego imie i nazwisko oraz wszystkie wycieczki na ktorych byl razem z celem podrozy (po id wycieczek)
CREATE VIEW TurystaIWycieczki
AS
SELECT DISTINCT Turysta.Imie, Turysta.Nazwisko,Turysta.ID_Turysty, Wycieczka.ID_Wycieczki, Miejsce_wycieczki FROM Turysta
JOIN PrzynaleznoscDoGrupy ON PrzynaleznoscDoGrupy.ID_Turysty = Turysta.ID_Turysty
JOIN Grupa ON PrzynaleznoscDoGrupy.ID_Grupy = Grupa.ID_Grupy
JOIN PrzeprowadzanieWycieczki ON PrzeprowadzanieWycieczki.ID_Grupy = Grupa.ID_Grupy
JOIN Wycieczka ON Wycieczka.ID_Wycieczki = PrzeprowadzanieWycieczki.ID_Wycieczki;

-- view majacy w sobie ��czny zarobek z danej wycieczki
CREATE VIEW WycieczkaZarobek
AS 
SELECT ID_Wycieczki, COUNT(ILOSC)*Cena_biletu as 'Przych�d' FROM (
	SELECT DISTINCT Cena_biletu, Wycieczka.ID_Wycieczki, PrzynaleznoscDoGrupy.ID_Turysty AS ILOSC FROM Wycieczka
	JOIN PrzeprowadzanieWycieczki ON PrzeprowadzanieWycieczki.ID_Wycieczki = Wycieczka.ID_Wycieczki
	JOIN Grupa ON Grupa.ID_Grupy = PrzeprowadzanieWycieczki.ID_Grupy
	JOIN PrzynaleznoscDoGrupy ON PrzynaleznoscDoGrupy.ID_Grupy = Grupa.ID_Grupy) AS x
GROUP BY ID_Wycieczki, Cena_biletu;

-- view maj�cy id grupy i informacje o jej przewodniku
CREATE VIEW GrupaZPrzewodnikiem
AS
SELECT ID_Grupy, Pesel, Imie, Nazwisko FROM Grupa
JOIN Przewodnik ON Przewodnik.PESEL = Grupa.PESEL_przewodnika;

-- view zawieraj�cy id wycieczki, ilosc dni tej wycieczki, cena za closc i �redni� cene za 1 dzien wycieczki
CREATE VIEW WycieczkaDniSredniaCena
AS
SELECT ID_Wycieczki, 
	   ABS(DATEDIFF(Data_rozpoczecia, Data_zakonczenia)) AS 'Ilo�� dni',
	   Cena_biletu,
	   ABS(Cena_biletu / DATEDIFF(Data_rozpoczecia, Data_zakonczenia)) as '�rednia cena za 1 dzie�' 
FROM Wycieczka;