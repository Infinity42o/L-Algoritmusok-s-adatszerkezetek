# Sherlock és a Költség Feladat

## Feladat Leírása:

Ebben a feladatban adott egy \( B \) tömb, és ki kell alakítani egy \( A \) tömböt. Van egy speciális szabály: minden \( i \)-re \( 1 \leq A[i] \leq B[i] \). Vagyis \( A[i] \) lehet bármilyen szám, amit választasz, de meg kell felelnie annak a szabálynak, hogy \( A[i] \leq B[i] \). A feladatod, hogy úgy válaszd meg az \( A \) tömb elemeit, hogy az egymást követő elemek abszolút különbségeinek összege a lehető legnagyobb legyen. Ez lesz az \( A \) tömb "költsége", amit az \( S \) változó fog képviselni.

Az egyenlet az alábbi módon írható fel:

\[S = \sum_{i=2}^{N} |A[i] - A[i-1]|\]

Például, ha a \( B = [1, 2, 3] \) tömb adott, akkor \( 1 \leq A[1] \leq 1 \), \( 1 \leq A[2] \leq 2 \), és \( 1 \leq A[3] \leq 3 \). Az ezeknek megfelelő \( A \) tömbök lehetnek például:

\[[1,1,1], \quad [1,1,2], \quad [1,1,3]\]\[
[2,1,1], \quad [2,2,2], \quad [2,2,3]\]

Az ezekhez tartozó költségek kiszámítása:

\[|1-1| + |1-1| = 0\]
\[|1-1| + |1-2| = 1\]
\[|1-1| + |1-3| = 2\]
\[|2-1| + |1-1| = 2\]
\[|2-1| + |1-2| = 2\]
\[|2-2| + |2-3| = 2\]

A maximális elérhető érték ebben az esetben 2.

## Függvény Leírása:

Fejezd be a `cost` függvény megvalósítását az alábbiak szerint. A függvény visszaadja a maximális értéket, amit elérhetünk.

A `cost` függvény az alábbi paraméterrel rendelkezik:
- **B**: egy egész számokból álló tömb.

## Bemeneti Formátum:

Az első sor tartalmazza a \( t \), azaz a tesztesetek számát. A következő \( t \) teszteset mindegyike két sort tartalmaz:
- Az első sor tartalmazza \( n \)-t, ami a \( B \) tömb hosszát adja meg.
- A második sor tartalmazza a \( B[i] \) értékeket.

## Korlátozások:

- \( 1 \leq t \leq 20 \)
- \( 1 \leq n \leq 10^5 \)
- \( 1 \leq B[i] \leq 100 \)

## Kimeneti Formátum:

Minden tesztesetnél írd ki a maximális összeget egy külön sorba.

## Minta Bemenet:

1 5 10 1 10 1 10


## Magyarázat:

A maximális összeg akkor adódik, ha \( A[1]=A[3]=A[5]=10 \), és \( A[2]=A[4]=1 \). Tehát az összeget az alábbi módon számíthatjuk ki:

\[|1 - 10| + |10 - 1| + |1 - 10| + |10 - 1| = 36\]
