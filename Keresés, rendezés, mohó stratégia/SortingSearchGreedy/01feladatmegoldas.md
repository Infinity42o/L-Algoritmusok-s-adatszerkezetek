# Gridland Metro Feladat Megoldásának Magyarázata
Feladat összefoglalása:
Gridland városát egy 𝑛×𝑚-es mátrix reprezentálja, ahol vízszintes vasúti sínek futnak sorok mentén. A cél az, hogy meghatározzuk, hány szabad cella maradt a mátrixban, ahol lámpaoszlopokat lehet telepíteni. Mivel a sínek átfedhetik egymást ugyanabban a sorban, az átfedéseket egyesíteni kell.

## Megoldási stratégia:
A feladat egy mohó algoritmussal, valamint keresési és rendezési módszerekkel oldható meg. A cél az, hogy soronként azonosítsuk a sínek által elfoglalt tartományokat, egyesítsük az átfedő tartományokat, majd kiszámoljuk a foglalt cellákat. Végül a teljes mátrix celláinak számából kivonjuk a foglalt cellák számát, hogy megkapjuk a szabad cellák mennyiségét.

# Lépések a megoldásban:
## Vasúti sínek tárolása:

A síneket sorok szerint csoportosítjuk egy térképben (Map<Integer, List<int[]>>), ahol a kulcs a sor száma, az érték pedig a sorban lévő sínszakaszok listája.
## Sínek rendezése:

A soron belüli sínszakaszokat a kezdő pozíciójuk szerint rendezzük, hogy könnyen egyesíthessük az átfedő vagy egymáshoz közeli sínszakaszokat.
## Sínek egyesítése:

A rendezett sínszakaszokból egyesítjük az átfedő vagy összefüggő tartományokat. Például, ha az egyik sín tartománya [𝑐1,𝑐2], és a következő sín tartománya [𝑐3,𝑐4], és 𝑐3≤𝑐2+1, akkor egyesítjük őket egyetlen tartománnyá [𝑐1,𝑐4].
## Foglalás számítása:

Minden sor esetében kiszámoljuk, hogy hány cellát foglalnak el a sínek az egyesített tartományok alapján. Ez úgy történik, hogy minden tartomány (𝑠𝑡𝑎𝑟𝑡, 𝑒𝑛𝑑) esetében a foglalt cellák száma 𝑒𝑛𝑑−𝑠𝑡𝑎𝑟𝑡+1.
## Szabad cellák számítása:
Az összes cella számát (𝑛×𝑚) kiszámoljuk. Ebből kivonjuk a foglalt cellák számát, amelyet az előző lépésekben kiszámoltunk, így megkapjuk a lámpaoszlopok számára elérhető cellák számát.

## Idő- és térbeli komplexitás:
Időbeli komplexitás: Mivel minden sínszakaszt rendezni kell soronként, a komplexitás 𝑂(𝑘 log ⁡𝑘), ahol 𝑘 a sínek száma.
Térbeli komplexitás: A térkép tárolása soronként 𝑂(𝑘) helyet igényel, ahol 𝑘 a sínek száma.

Példák:
Bemenet:
n = 4, m = 4, k = 3
track = [(2, 2, 3), (3, 1, 4), (4, 4, 4)]

Kimenet:
9

Magyarázat:
Az összes cella száma 4×4=16.
A sínek által foglalt cellák száma 7 (sor 2: 2 cella, sor 3: 4 cella, sor 4: 1 cella).
Szabad cellák száma: 16−7=9.