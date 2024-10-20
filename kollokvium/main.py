# Függvény, amely kiszámolja a minimális füstöt a keverékek összekeverésekor
def mixtures_smoke(colors):
    n = len(colors)  # A keverékek száma
    # dp[i][j] tárolja a minimális füst mennyiségét, ami az i-től j-ig terjedő keverékek összekeveréséből keletkezik
    dp = [[0] * n for _ in range(n)]
    # sum_mod[i][j] tárolja az i-től j-ig terjedő keverékek eredményül kapott színét mod 100 alapján
    sum_mod = [[0] * n for _ in range(n)]

    # sum_mod inicializálása, egy keverékre vonatkozóan (önmagával keverve)
    for i in range(n):
        sum_mod[i][i] = colors[i]

    # A dp és sum_mod feltöltése minden lehetséges keverék kombinációra
    for length in range(2, n+1):  # A subprobléma hossza
        for i in range(n - length + 1):
            j = i + length - 1
            dp[i][j] = float('inf')  # Kezdetben nagyon nagy értékre állítjuk

            # Végigmegyünk az i és j közötti összes lehetséges bontási ponton
            for k in range(i, j):
                # Kiszámítjuk a füst mennyiségét, ha az i-től k-ig és a k+1-től j-ig terjedő részeket keverjük
                smoke = dp[i][k] + dp[k+1][j] + sum_mod[i][k] * sum_mod[k+1][j]
                if smoke < dp[i][j]:  # Ha az aktuális füst kevesebb, mint az eddigi minimum
                    dp[i][j] = smoke  # Frissítjük a minimális füst értéket
                    # Frissítjük a keverékek színét (mod 100)
                    sum_mod[i][j] = (sum_mod[i][k] + sum_mod[k+1][j]) % 100

    # Visszatérünk a minimális füst mennyiségével az első és az utolsó keverék között
    return dp[0][n-1]

# Főprogram, amely beolvassa a bemenetet és meghívja a függvényt
def main():
    while True:
        try:
            # Beolvassuk a keverékek számát
            n = int(input())
            # Beolvassuk a keverékek színeit
            colors = list(map(int, input().split()))
            # Meghívjuk a függvényt, és kiírjuk az eredményt
            print(mixtures_smoke(colors))
        except EOFError:
            break  # Ha elérjük a bemenet végét, kilépünk a ciklusból

# A program futtatása
if __name__ == "__main__":
    main()
