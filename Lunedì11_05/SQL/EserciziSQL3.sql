Create DATABASE if not exists Negozio;
Use Negozio;

/*
Esercizio 1 – INNER JOIN + WHERE + LIKE
Visualizzare l’elenco dei libri venduti in almeno un negozio, mostrando:
 titolo del libro, autore, data_vendita, negozio.
 Includere solo i libri il cui autore contiene la stringa “King” (indipendentemente da maiuscole/
minuscole).
*/
Select l.titolo, l.autore, v.data_vendita, v.negozio
from Libri l 
inner join Vendite v
on l.id = v.id_libro
where LOWER(l.autore) like "%king%";

/*
Esercizio 2 – LEFT JOIN + WHERE + BETWEEN
Visualizzare tutti i libri, anche quelli che non hanno ancora vendite registrate, mostrando per ciascuno:
 titolo, anno_pubblicazione, prezzo, data_vendita (se presente).
 Filtrare i risultati per anno_pubblicazione compreso tra 2000 e 2010. */
select l.titolo, l.anno_pubblicazione, l.prezzo, v.data_vendita
from Libri l
left join Vendite v
on l.id = v.id_libro
where l.anno_pubblicazione between 2000 and 2010;


/*
Esercizio 3 – INNER JOIN + WHERE + IN
Visualizzare i dati dei libri venduti nei negozi appartenenti a una lista specifica:
("9 Oriole Lane", "98558 Milwaukee Point", "98016 Esch Trail").
Mostrare titolo, negozio, quantita, prezzo totale (quantita * prezzo).*/
select l.titolo, v.negozio, v.quantita, v.quantita*l.prezzo as prezzo_totale
from Libri l
inner join Vendite v
where v.negozio IN("9 Oriole Lane", "98558 Milwaukee Point", "98016 Esch Trail");

/*
Esercizio 4 – RIGHT JOIN + WHERE + LIKE + BETWEEN
Mostrare tutti i record di vendita, anche quelli che fanno riferimento a libri non più presenti nella
tabella Libri (caso anomalo).
 Mostrare: titolo (se esiste), data_vendita, prezzo, quantita.
 Includere solo le vendite:
avvenute tra il 2020-01-01 e il 2022-12-31
presso negozi il cui nome contiene la parola “Drive” (case-insensitive).*/

select l.titolo, v.data_vendita, l.prezzo, v.quantita
from Libri l
right join Vendite v
on l.id = v.id_libro
where data_vendita between '2020-01-01' and '2022-12-31' and LOWER(v.negozio) like "%drive%";

/*
Esercizio 5 – INNER JOIN + WHERE combinato
Mostrare titolo, autore, prezzo e data_vendita dei libri:
con genere IN (‘Fantasy’, ‘Horror’, ‘Drama’) (ignora i libri con >1 genere)
con data_vendita dopo il 2015,
venduti in negozi il cui nome contiene ‘Plaza’,
ordinati dal più recente al più vecchio.*/

select l.titolo, l.autore, l.prezzo, v.data_vendita, v.negozio -- so che non c'è nella consegna ma mi serve per verifica
from Libri l
inner join Vendite v
on l.id = v.id_libro
where v.data_vendita > 2015 and LOWER(v.negozio) like "%plaza%" and l.genere IN("Fantasy", "Horror", "Drama")
order by l.anno_pubblicazione ASC;
