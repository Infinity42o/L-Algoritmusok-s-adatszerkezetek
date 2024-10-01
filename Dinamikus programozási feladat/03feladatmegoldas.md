# Megoldás Stratégia:
A megoldás alapötlete egy dinamikus programozási megközelítés (mert annak is kell lennie), amely során két állapotot követünk nyomon:

low: Az aktuális költség, ha 𝐴[𝑖]=1.
high: Az aktuális költség, ha 𝐴[𝑖]=𝐵[𝑖].
Mivel 𝐴[𝑖] minden egyes helyen vagy 1, vagy 𝐵[𝑖] lehet, mindkét esetet nyomon követjük, és a következő elem elhelyezésekor meghatározzuk a legnagyobb lehetséges költséget mindkét lehetőségre.

## Lépések a kódban:
Inicializálás: Az első elemhez képest az 𝐴[1] értéke lehet 1 vagy 𝐵[1], ezért két változót, 𝑙𝑜𝑤-t és ℎ𝑖𝑔ℎ-t inicializálunk. Ezek kezdetben 0-k, mivel nincs előző elem, amihez viszonyítani lehetne.

int low = 0;
int high = 0;

## Iteráció a listán: A for ciklus segítségével a második elemtől (index 1-től) kezdve iterálunk a tömbön. Minden iterációnál két új értéket számolunk ki: 𝑙𝑜𝑤𝑁𝑒𝑥𝑡 és ℎ𝑖𝑔ℎ𝑁𝑒𝑥𝑡, amelyek az aktuális elemhez viszonyítva adják meg a legjobb költséget.

lowNext: Az aktuális költség, ha 𝐴[𝑖]=1. Ebben az esetben az előző érték lehet 𝐴[𝑖−1]=1 vagy 𝐴[𝑖−1]=𝐵[𝑖−1].
highNext: Az aktuális költség, ha 𝐴[𝑖]=𝐵[𝑖]. Ebben az esetben az előző érték szintén lehet 1 vagy 𝐵[𝑖−1], és az abszolút különbségeket számoljuk ki.

for (int i = 1; i < n; i++) {
    int lowNext = Math.max(low, high + Math.abs(B.get(i-1) - 1));
    int highNext = Math.max(low + Math.abs(1 - B.get(i)), high + Math.abs(B.get(i-1) - B.get(i)));

    low = lowNext;
    high = highNext;
}
Például:
-Ha az előző elem 𝐴[𝑖−1]=1, akkor ∣1−𝐵[𝑖]∣-et számolunk a következő elemhez, ha 𝐴[𝑖]=𝐵[𝑖].
-Ha az előző elem 𝐴[𝑖−1]=𝐵[𝑖−1], akkor ∣𝐵[𝑖−1]−𝐵[𝑖]∣-et számolunk, ha 𝐴[𝑖]=𝐵[𝑖].

## Eredmény kiszámítása: 
A for ciklus befejezése után a végső költség a 𝑙𝑜𝑤 és a ℎ𝑖𝑔ℎ állapotok maximuma lesz, hiszen ezek tartalmazzák a két lehetséges legnagyobb értéket az utolsó elem figyelembevételével.

return Math.max(low, high);

## Bemenet kezelése és kimenet írása: 
A main függvényben a bemenetet beolvassuk, majd a cost függvényt hívjuk meg minden tesztesetnél. Az eredményeket a kimenetre írjuk.

## Dinamikus Programozás Előnye:
Az eljárás hatékony, mivel az iteráció minden egyes elemnél csak két állapotot tart számon (low és high), így az algoritmus időbeli komplexitása 𝑂(𝑛), ahol 𝑛 a tömb hossza. Ez elegendően gyors ahhoz, hogy a nagy méretű bemeneteket is kezelje, ahol 𝑛 akár 10^5 lehet.

Példák:
Bemenet:
1
5
10 1 10 1 10

Kimenet:
36

Magyarázat: A maximális összeg akkor adódik, ha 𝐴[1]=10, 𝐴[2]=1, 𝐴[3]=10, 𝐴[4]=1, és 𝐴[5]=10. 
Az abszolút különbségek összege:
∣10−1∣+∣1−10∣+∣10−1∣+∣1−10∣=36.
Ez a megoldás alapvetően dinamikus programozást használ, és optimalizálja az abszolút különbségek maximális összegét az elemek kiválasztásán keresztül.