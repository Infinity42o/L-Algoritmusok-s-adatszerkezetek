# Even Tree - Páros Fa Feladat

## Feladat Leírása:

Adott egy fa (egyszerű, összefüggő gráf ciklusok nélkül).

A feladat, hogy találjuk meg a maximálisan eltávolítható élek számát a fából úgy, hogy minden egyes összefüggő komponensben, amelyet az élek eltávolítása után kapunk, páros számú csomópont legyen.

Példaként a következő fát 4 csomóponttal legfeljebb egyszer vághatjuk el, hogy egy páros fát hozzunk létre.

## Függvény Leírása:

Készítsd el az `evenForest` függvényt az alábbiak szerint, amely visszaad egy egész számot, ahogy az le van írva.

Az `evenForest` függvény az alábbi paraméterekkel rendelkezik:
- **t_nodes**: a fa csomópontjainak száma
- **t_edges**: a fa éleinek száma
- **t_from**: a kezdő csomópontok minden élhez
- **t_to**: a végpontok minden élhez (index szerint illeszd össze a `t_from`-mal)

## Bemeneti Formátum:

Az első sor két egész számot tartalmaz, **t_nodes** és **t_edges**, amelyek a csomópontok és élek számát adják meg.

A következő **t_edges** sor mindegyike két egész számot tartalmaz, **t_from[i]** és **t_to[i]**, amelyek megadják az élek kezdő és végpontját. A fa gyökere az 1-es csomópont.

## Korlátozások:
- \( 2 \leq n \leq 100 \)
- \( n \in Z_{\text{even}}^+ \)

Megjegyzés: A bemenetben megadott fa mindig olyan lesz, hogy páros számú csomópontú komponensekre bontható.

## Kimeneti Formátum:

Írd ki az eltávolítható élek számát.

## Minta Bemenet 1:

10 9 2 1 3 1 4 3 5 2 6 1 7 2 8 6 9 8 10 8


## Minta Kimenet 1:


## Magyarázat:

Az 1-es és a 3-as, valamint az 1-es és a 6-os közötti élek eltávolításával megkapjuk a kívánt eredményt.
