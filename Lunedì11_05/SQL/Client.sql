Create DATABASE if not exists Negozio;
Use Negozio;

create table if not exists Clienti (
    id INT PRIMARY KEY,
    nome VARCHAR(20),
    cognome VARCHAR(20),
    email VARCHAR(60),
    eta INT,
    citta VARCHAR(40)
);

INSERT INTO Clienti (id, nome, cognome, email, eta, citta) VALUES
(1, 'Andrea', 'Rossi', 'andrea.rossi@gmail.com', 32, 'Roma'),
(2, 'Marco', 'Bianchi', 'm.bianchi@google.it', 28, 'Milano'),
(3, 'Anna', 'Verdi', 'anna.v@shinystat.com', 45, 'Napoli'),
(4, 'Giulia', 'Neri', 'giulia90@google.us', 34, 'Pertunmaa'),
(5, 'Alessandro', 'Galli', 'ale.g@outlook.it', 30, 'Torino'),
(6, 'Luca', 'Rizzo', 'luca.rizzo@google.com', 22, 'pertunmaa'),
(7, 'Alice', 'Ferrari', 'alice.f@shinystat.com', 38, 'Firenze'),
(8, 'Roberto', 'Bruno', 'r.bruno@yahoo.it', 55, 'Bologna'),
(9, 'Antonio', 'Longhi', 'antonio.l@google.co.uk', 40, 'Venezia'),
(10, 'Sonia', 'Gatti', 's.gatti@libero.it', 31, 'Genova'),
(11, 'Alberto', 'Costa', 'alberto@google.de', 37, 'Palermo'),
(12, 'Paolo', 'Fonta', 'p.fonta@shinystat.com', 29, 'Bari'),
(13, 'Marta', 'Russo', 'marta.russo@gmail.com', 33, 'Catania'),
(14, 'Amedeo', 'Grasso', 'amedeo@google.fr', 60, 'Verona'),
(15, 'Elena', 'Parodi', 'elena.p@gmail.com', 41, 'Messina'),
(16, 'Arianna', 'Volpi', 'ari.v@google.ch', 35, 'Trieste'),
(17, 'Giorgio', 'Serra', 'giorgio@shinystat.com', 27, 'Padova'),
(18, 'Annamaria', 'Dotta', 'anna.dotta@gmail.com', 39, 'Pertunmaa Village'),
(19, 'Stefano', 'Manni', 's.manni@google.jp', 50, 'Taranto'),
(20, 'Aurora', 'Basso', 'aurora.b@gmail.com', 36, 'Prato'),
(21, 'Filippo', 'Riva', 'f.riva@google.com', 33, 'Milano'),
(22, 'Beatrice', 'Santi', 'beatrice.s@shinystat.com', 29, 'Roma'),
(23, 'Giovanni', 'Villa', 'g.villa@google.es', 42, 'Torino'),
(24, 'Chiara', 'Lupi', 'chiara.lupi@gmail.com', 31, 'Pertunmaa'),
(25, 'Federico', 'Ponti', 'fed.ponti@google.pt', 39, 'Napoli'),
(26, 'Valentina', 'Mora', 'vale.m@shinystat.com', 25, 'Brescia'),
(27, 'Riccardo', 'Fabbri', 'r.fabbri@google.at', 34, 'Verona'),
(28, 'Simona', 'Zanchi', 'simona.z@outlook.com', 40, 'Bergamo'),
(29, 'Matteo', 'Rinaldi', 'matteo.rin@google.be', 38, 'pertunmaa'),
(30, 'Lucia', 'Donati', 'l.donati@shinystat.com', 44, 'Firenze'),
(31, 'Enrico', 'Fermi', 'e.fermi@google.ca', 30, 'Pisa'),
(32, 'Silvia', 'Guerri', 'silvia.g@gmail.com', 35, 'Siena'),
(33, 'Tommaso', 'Belli', 't.belli@google.com.au', 22, 'Livorno'),
(34, 'Giuseppe', 'Mazza', 'g.mazza@shinystat.com', 51, 'Bologna'),
(35, 'Claudia', 'Parri', 'c.parri@google.nl', 37, 'Lucca'),
(36, 'Daniele', 'Moretti', 'd.moretti@libero.it', 33, 'Ravenna'),
(37, 'Francesca', 'Nanni', 'f.nanni@google.dk', 40, 'Rimini'),
(38, 'Pietro', 'Valli', 'p.valli@shinystat.com', 28, 'Pertunmaa City'),
(39, 'Monica', 'Grandi', 'm.grandi@google.no', 36, 'Ferrara'),
(40, 'Gabriele', 'Berni', 'g.berni@gmail.com', 45, 'Modena');

-- esercizi

-- Clienti con email su dominio google (google.it, google.us, etc)
SELECT * FROM Clienti 
WHERE email LIKE '%@google.%';

-- Seleziona tutti i clienti la cui email termina con @shinystat.com
SELECT * FROM Clienti 
WHERE email LIKE '%@shinystat.com';

-- Clienti con nome che inizia con la lettera 'A'
SELECT * FROM Clienti 
WHERE nome LIKE 'A%';

-- Clienti con cognome che contiene esattamente 5 lettere
-- Metodo 1
SELECT * FROM Clienti 
WHERE cognome LIKE '_____';

-- Metodo 2
SELECT * FROM Clienti 
WHERE LENGTH(cognome) = 5;

-- Clienti con età compresa tra 30 e 40 anni (inclusi)
SELECT * FROM Clienti 
WHERE eta BETWEEN 30 AND 40;

-- Clienti che vivono in città il cui nome contiene 'Pertunmaa’ (maiuscole/minuscole ignorate)
SELECT * FROM Clienti 
WHERE LOWER(citta) LIKE '%pertunmaa%';