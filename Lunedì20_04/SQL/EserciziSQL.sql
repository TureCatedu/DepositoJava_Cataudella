Create DATABASE if not exists Negozio;
Use Negozio;

create table if not exists Libri (
    id INT PRIMARY KEY,
    titolo VARCHAR(100),
    autore VARCHAR(100),
    genere VARCHAR(50),
    prezzo DECIMAL(5,2),
    anno_pubblicazione INT
);

create table if not exists Vendite (
    id INT,
    prodotto VARCHAR(100),
    categoria VARCHAR(50),
    quantita INT,
    prezzo_unitario DECIMAL(6,2),
    data_vendita DATE
);

INSERT INTO Libri Values (1, "Viaggio", "Roberto", "Fantasy", 46.50, 2026);
INSERT INTO Libri Values (2, "Albero", "Angelo", "Avventura", 47.50, 2025);
INSERT INTO Libri Values (3, "Cibo", "Andrea", "Giallo", 26.50, 2024);
INSERT INTO Libri Values (4, "Aereo", "JK", "Mistero", 36.50, 2023);
INSERT INTO Libri Values (5, "Macchina", "Franco", "Horror", 11.50, 2022);
INSERT INTO Libri Values (6, "Storia", "Alberto", "Tecnologia", 66.50, 2021);

INSERT INTO Vendite (id, prodotto, categoria, quantita, prezzo_unitario, data_vendita) VALUES
(1, 'Laptop Pro 15', 'Elettronica', 1, 1200.00, '2024-01-10'),
(2, 'Mouse Wireless', 'Accessori', 5, 25.50, '2024-01-12'),
(3, 'Monitor 27 Pollici', 'Elettronica', 2, 299.99, '2024-01-15'),
(4, 'Sedia Ergonomica', 'Arredamento', 1, 185.00, '2024-01-18'),
(5, 'Tastiera Meccanica', 'Accessori', 3, 89.00, '2024-01-20'),
(6, 'Smartphone X1', 'Elettronica', 2, 650.00, '2024-01-22'),
(7, 'Lampada da Scrivania', 'Arredamento', 4, 35.00, '2024-01-25'),
(8, 'Cuffie Noise Cancelling', 'Accessori', 1, 150.00, '2024-01-28'),
(9, 'Stampante Laser', 'Elettronica', 1, 210.00, '2024-01-30'),
(10, 'Webcam HD', 'Accessori', 10, 45.00, '2024-02-01'),
(11, 'Hard Disk Esterno 2TB', 'Accessori', 2, 75.00, '2024-02-03'),
(12, 'Scrivania Regolabile', 'Arredamento', 1, 320.00, '2024-02-05'),
(13, 'Cavo HDMI 2.1', 'Accessori', 15, 12.99, '2024-02-07'),
(14, 'Tablet Grafico', 'Elettronica', 1, 450.00, '2024-02-10'),
(15, 'Supporto Laptop', 'Accessori', 3, 29.00, '2024-02-12'),
(16, 'Libreria Modulare', 'Arredamento', 2, 110.00, '2024-02-14'),
(17, 'Altoparlante Bluetooth', 'Elettronica', 5, 55.00, '2024-02-16'),
(18, 'Zaino Porta PC', 'Accessori', 4, 45.50, '2024-02-18'),
(19, 'Microfono USB', 'Accessori', 2, 125.00, '2024-02-20'),
(20, 'Power Bank 20000mAh', 'Accessori', 8, 39.90, '2024-02-22');


SELECT COUNT(id) as numero_libri, genere, AVG(prezzo) as prezzo_media
From Libri
Group by genere
Order by genere ASC;

Select titolo
from Libri 
where anno_pubblicazione > 2010
order by anno_pubblicazione DESC, prezzo ASC;

Select Count(id) as numero_vendite, categoria
from Vendite
Group by categoria;

Select AVG(prezzo_unitario) as prezzo_medio, categoria
from Vendite 
group by categoria;

Select SUM(quantita) as quantita_vendita, prodotto
from Vendite
group by prodotto;

SELECT DISTINCT prodotto, prezzo_unitario
FROM Vendite
WHERE prezzo_unitario = (SELECT MAX(prezzo_unitario) FROM Vendite)
   OR prezzo_unitario = (SELECT MIN(prezzo_unitario) FROM Vendite);

Select Count(*)
from Vendite;

Select prezzo_unitario, prodotto
from Vendite
order by prezzo_unitario DESC
LIMIT 5;

Select prodotto, SUM(quantita) as somma
from Vendite
group by prodotto
order by somma ASC
LIMIT 3;




