# 1. feladat: Keresés, rendezés, mohó stratégia

Link:[text](https://www.hackerrank.com/challenges/gridland-metro/problem?isFullScreen=true)

## A feladat leírása:

## Gridland városának feladata.

Gridland városát egy 𝑛×𝑚-es mátrix reprezentálja, ahol a sorokat 1-től 𝑛-ig, az oszlopokat pedig 1-től 𝑚-ig számozzuk. Gridland egy olyan vasúti pályahálózattal rendelkezik, amely mindig egyenes vízszintes vonalakban fut egy adott sor mentén. Más szavakkal, egy vasúti sín kezdő- és végpontja a (𝑟,𝑐1) és (𝑟,𝑐2), ahol 𝑟 a sor számát, 𝑐1 a kezdő oszlopot, 𝑐2 pedig a vég oszlopot jelenti a vasúti sín számára.

Gridland polgármestere felméri a várost, hogy meghatározza, hány helyen lehet lámpaoszlopokat elhelyezni. Lámpaoszlop minden olyan cellában elhelyezhető, amelyet nem foglal el vasúti sín.

Adott Gridland térképe és annak 𝑘 vasúti sínje, számítsd ki és írd ki, hány olyan cella van, ahová a polgármester lámpaoszlopot helyezhet.

Megjegyzés: Egy vasúti sín átfedhet más síneket ugyanabban a sorban.

Példa
Ha Gridland adatai a következők (1-alapú indexelés): k = 3
r c1 c2
1 1 4
2 2 4
3 1 2
4 2 3

Ez az alábbi térképet eredményezi:

Ebben az esetben öt nyitott cella van (piros színnel), ahová lámpaoszlopok helyezhetők.

## Függvény leírása
Fejezd be a gridlandMetro nevű függvényt az alábbi paraméterekkel:

int n: Gridland sorainak száma
int m: Gridland oszlopainak száma
int k: a sínek száma
track[k][3]: minden elem három egész számot tartalmaz, amelyek a sor számát, a sín kezdő oszlopát és a sín vég oszlopát reprezentálják, 1-indexelve
Visszatérési érték
int: azon cellák száma, ahová lámpaoszlopokat lehet telepíteni
Bemeneti formátum
Az első sor három szóközzel elválasztott egész számot tartalmaz, 𝑛-t, 𝑚-t és 𝑘-t, amelyek a sorok, oszlopok és a sínek számát adják meg.
A következő 𝑘 sor mindegyike három szóközzel elválasztott egész számot tartalmaz: 𝑟, 𝑐1 és 𝑐2, amelyek a sor számát, a sín kezdő és vég oszlopát adják meg.
Korlátozások

1≤n,m≤10^9
0≤𝑘≤1000
1≤𝑟≤𝑛
1≤𝑐1≤𝑐2≤𝑚

Minta bemenet

STDIN   Függvény
-----   --------
4 4 3   n = 4, m = 4, k = 3
2 2 3   track = [[2, 2, 3], [3, 1, 4], [4, 4, 4]]
3 1 4
4 4 4

Minta kimenet

9

A fenti ábrán a sárga cellák jelölik az első vasúti sínt, a zöld a másodikat, a kék a harmadikat. Lámpaoszlopokat a kilenc piros cellába lehet helyezni.