# MIXTURES megoldás - Dinamikus programozás részletes magyarázata

## 1. Probléma felbontása részekre

A feladat lényege, hogy keverékeket keverünk, miközben minimalizáljuk a keletkező füstöt. Mivel a keverékeket többféle sorrendben is össze lehet keverni, az eredmény változhat. Ez egy klasszikus optimalizálási probléma, ahol a cél a minimális füst megtalálása.

A probléma természetéből fakadóan kisebb részproblémákra bontható: ha az i-től j-ig terjedő keverékeket szeretnénk keverni, akkor ezeket több ponton is kettébonthatjuk. A kisebb intervallumokat külön-külön megoldjuk, majd összevonjuk őket. Ezt nevezik **részeredményekre bontásnak**, ami a dinamikus programozás egyik alapvető technikája.

## 2. Dinamikus programozási modell

Mivel többféle sorrendben is össze lehet keverni a keverékeket, két táblát használunk az eredmények tárolására:
- **dp[i][j]**: Ez a tábla tárolja a minimális füst mennyiségét, amely az i-től j-ig terjedő keverékek összekeveréséből keletkezik.
- **sum_mod[i][j]**: Ez a tábla tárolja az i és j közötti keverékek eredményül kapott színét, az **(a + b) mod 100** alapján.

Ezeket a táblázatokat fokozatosan töltjük fel, ahogy haladunk előre a keverési folyamatban. A kisebb részek megoldásait felhasználjuk a nagyobb problémák megoldásához.

## 3. Részproblémák megoldása

Az alapelv az, hogy először a kisebb intervallumokat oldjuk meg, például két keverék összevonását. Ezután egyre nagyobb intervallumokat kezelünk, például három vagy több keverék összevonását. Minden lehetséges keverési sorrendet kipróbálunk, és az egyes részeredményeket eltároljuk a **dp** és **sum_mod** táblákban.

Ha az i-től j-ig terjedő keveréket akarjuk kezelni, akkor először két részre bontjuk (például i-től k-ig és k+1-től j-ig). Mindkét részt külön-külön megoldjuk, majd összevonjuk őket. Az összevonás során keletkező füst mennyisége a következőképpen számolható ki:
- **dp[i][k]**: Az i-től k-ig terjedő részek keverése során keletkező füst.
- **dp[k+1][j]**: A k+1-től j-ig terjedő részek keverése során keletkező füst.
- **sum_mod[i][k] * sum_mod[k+1][j]**: Az új füst mennyisége a két résztartomány összekeverésekor.

## 4. Optimalizálás

Az optimalizálás során minden lehetséges bontási pontot megvizsgálunk az i és j közötti tartományban, és kiválasztjuk azt a felosztást, amely a legkevesebb füstöt eredményezi. Mivel a korábban kiszámolt részeredményeket eltároljuk, újra felhasználhatjuk őket a nagyobb problémák megoldásánál, így jelentősen csökkentve a számítási költséget.

## 5. Miért szükséges a dinamikus programozás?

A dinamikus programozás alkalmazása elengedhetetlen, mert ha minden lehetséges keverési sorrendet külön számolnánk ki, az exponenciális időigényű lenne. Az összes lehetséges megoldás kipróbálása nem lenne hatékony. Ehelyett a dinamikus programozás lehetővé teszi, hogy a korábban kiszámolt részeredményeket eltároljuk és újra felhasználjuk, így minden résztartományhoz csak egyszer kell kiszámolni a minimális füst mennyiségét.

A dinamikus programozásnak köszönhetően a probléma polinomiális időben oldható meg, ami sokkal hatékonyabb, mint az összes lehetséges megoldás kipróbálása. Ezáltal a probléma megoldható a maximálisan megengedett keverékek számával, azaz n = 100 esetén is.
