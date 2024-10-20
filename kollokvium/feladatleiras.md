# MIXTURES - Keverékek

[text](https://www.spoj.com/problems/MIXTURES/)

Harry Potter előtt n keverék található, sorban elrendezve. Minden keverék egy 100 különböző színből álló színnel rendelkezik (a színek 0-tól 99-ig vannak számozva).

Harry szeretné az összes keveréket összekeverni. Minden lépésben két egymás melletti keveréket vesz, és összekeveri őket, majd az új keveréket az előző kettő helyére teszi.

Amikor két keveréket kever össze, amelyek színei a és b, az új keverék színe **(a + b) mod 100** lesz.

Emellett füst is keletkezik a folyamat során. A füst mennyisége, amikor a és b színű keveréket keverjük, **a * b** lesz.

Meg kell találni, hogy mi a minimális füst mennyisége, amit Harry elő tud állítani, amikor az összes keveréket összekeveri.

## Bemenet:
- Több teszteset szerepel a bemenetben.
- Minden teszteset első sora tartalmazza n-t, a keverékek számát, ahol **1 <= n <= 100**.
- A második sor tartalmaz n egész számot 0 és 99 között - ezek a keverékek kezdő színei.

## Kimenet:
- Minden tesztesethez ki kell írni a minimális füst mennyiségét.

## Példa:

### Bemenet:

 2 
 18 19 
 3 
 40 60 20

 
### Kimenet:

342 
2400

## Magyarázat:
A második tesztesetben két lehetőség van:
1. Először keverjük össze a 40-et és a 60-at (füst: 2400), majd kapunk egy 0-t, ezt keverjük össze a 20-szal (füst: 0). Az összes keletkezett füst: 2400.
2. Először keverjük össze a 60-at és a 20-at (füst: 1200), majd kapunk egy 80-at, ezt keverjük össze a 40-nel (füst: 3200). Az összes keletkezett füst: 4400.

Az első forgatókönyv sokkal jobb, mivel kevesebb füstöt eredményez.
