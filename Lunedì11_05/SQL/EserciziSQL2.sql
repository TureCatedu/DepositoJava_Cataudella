CREATE DATABASE IF NOT EXISTS Negozio;
USE Negozio;

-- esempio inner join
SELECT c2.nome, o.data_ordine, o.importo
FROM Clienti2 c2
INNER JOIN Ordini o
ON o.id_cliente = c2.id
ORDER BY c2.nome ASC;


-- esempio left/right join
SELECT c2.nome, o.data_ordine, o.importo
FROM Clienti2 c2
LEFT JOIN Ordini o
ON o.id_cliente = c2.id
ORDER BY c2.nome ASC;

-- Elenca i clienti attivi, cioè quelli che hanno effettuato almeno un ordine, mostrando per ciascuno:
-- Nome del cliente
-- Totale ordini effettuati
-- Somma totale degli importi spesi
SELECT 
    C.nome,
    COUNT(O.id) AS Totale_Ordini,
    SUM(O.importo) AS Totale_Speso
FROM Clienti2 C
INNER JOIN Ordini O ON C.id = O.id_cliente
GROUP BY C.nome;

-- Elenca i clienti inattivi, cioè quelli che non hanno mai effettuato ordini, mostrando solo:
-- Nome del cliente
-- Città di residenza
SELECT 
    C.nome,
    C.citta
FROM Clienti2 C
LEFT JOIN Ordini O ON C.id = O.id_cliente
WHERE O.id IS NULL;

-- Individua gli ordini orfani, cioè ordini presenti in tabella ma senza un cliente valido associato (es. cliente cancellato), e mostra:
-- ID dell’ordine
-- Data dell’ordine
-- Importo
-- (Cliente = NULL)
SELECT 
    O.id,
    O.data_ordine,
    O.importo,
    C.nome
FROM Clienti2 C
RIGHT JOIN Ordini O ON C.id = O.id_cliente
WHERE C.id IS NULL;

