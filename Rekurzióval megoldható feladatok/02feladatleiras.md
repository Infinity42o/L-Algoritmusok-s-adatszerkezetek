Feladat Leírása:

link: [text](https://www.hackerrank.com/challenges/crossword-puzzle/problem?isFullScreen=true)

Egy 10x10-es keresztrejtvény rácsot adunk meg, valamint egy listát szavakkal (vagy helynevekkel), amelyeket be kell illeszteni a rácsba. A cellák vagy "+" vagy "-" karakterekkel vannak jelölve. A "-" karakterek azok a cellák, ahová a szavakat kell illeszteni.

Az alábbiakban egy példa látható a keresztrejtvényre, valamint a beillesztendő szavak listájára:

Szavak = [POLAND, LHASA, SPAIN, INDIA]

Bemenet:

++++++++++
+POLAND+++
+N++++++++
+H+++SPAIN
+A+++++++I
+LHASA++++
++++++++++
++++++++++
++++++++++
++++++++++

Kimenet:

++++++++++
+POLAND+++
+N++++++++
+H+++SPAIN
+A+++++++I
+LHASA++++
++++++++++
++++++++++
++++++++++
++++++++++

Feladat Leírása:
Fejezd be a crosswordPuzzle függvény megírását. A függvénynek egy karakterláncokból álló tömböt kell visszaadnia, ahol minden egyes sor a befejezett rejtvény egy sorát reprezentálja.

A crosswordPuzzle függvény az alábbi paraméterekkel rendelkezik:

crossword: egy 10 hosszú karakterláncokat tartalmazó tömb, amely az üres rácsot képviseli.
words: egy karakterlánc, amely pontosvesszővel elválasztott szavakat tartalmaz, amelyeket be kell illeszteni a rejtvénybe.
Bemeneti Formátum:
Az első 10 sor mindegyike egy 10 karakter hosszú karakterláncot képvisel, amely a rács megfelelő sorát adja meg. A rács cellái "+" vagy "-" karakterekből állnak. A következő sor egy pontosvesszővel elválasztott szavakat tartalmazó karakterláncot tartalmaz.

Korlátozások:
1 ≤ |words| ≤ 10
A crossword[i][j] csak "+" vagy "-" karakter lehet.
A words[i] karakterei csak az [A-Z] ASCII karakterek lehetnek.
Kimeneti Formátum:
Helyezd be a szavakat a 10x10-es rácsba, majd add vissza a rács sorait tartalmazó tömböt nyomtatáshoz.