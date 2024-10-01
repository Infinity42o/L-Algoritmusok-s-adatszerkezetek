# Páros Fa Feladat Megoldásának Részletes Leírása

## Bevezetés

A feladat célja, hogy egy fa (egyszerű összefüggő gráf ciklusok nélkül) esetén maximáljuk az eltávolítható élek számát úgy, hogy az eltávolítás után a fa minden összefüggő komponense páros számú csomópontot tartalmazzon. A megoldáshoz egy **mélységi bejárást (DFS)** használunk a fa részfáinak méreteinek kiszámítására, és az élek eltávolításának meghatározására.

## Megoldás Stratégia

1. **Fa reprezentációja szomszédsági listával**:
   A gráfot szomszédsági listával reprezentáljuk. Minden csomópont egy listával van társítva, amely az adott csomópont szomszédait tartalmazza. Ez hatékony módja a gráf tárolásának és bejárásának.

   ```python
   tree = {i: [] for i in range(1, t_nodes + 1)}

## Élek hozzáadása: Az éleket kétirányúan adjuk hozzá, mivel a fa nem irányított. Minden élt hozzáadunk mindkét végpont szomszédsági listájához.

for i in range(t_edges):
    u, v = t_from[i], t_to[i]
    tree[u].append(v)
    tree[v].append(u)

## Látogatott csomópontok nyomon követése: Létrehozunk egy visited listát, amely nyomon követi, hogy egy csomópontot már meglátogattunk-e. Emellett egy subtree_size listát is használunk, amely minden csomópont részfájának méretét tárolja.

visited = [False] * (t_nodes + 1)
subtree_size = [0] * (t_nodes + 1)

## DFS függvény a részfák méretének kiszámításához: A mélységi bejárást (DFS) használjuk arra, hogy minden csomópontból kiindulva kiszámítsuk a részfák méretét. Minden csomópont hozzájárul saját részfájának méretéhez. Ahogy bejárjuk a szomszédokat, azok részfáit is hozzászámoljuk az adott csomópont részfájának méretéhez.

def dfs(node):
    nonlocal cut_count
    visited[node] = True
    size = 1  # Minden csomópont hozzájárul saját részfájának méretéhez

    for neighbor in tree[node]:
        if not visited[neighbor]:
            size += dfs(neighbor)

## Élek eltávolítása: Miután kiszámoltuk a részfák méretét, ha egy részfa mérete páros, és nem az egész fát (gyökeret) jelenti, akkor el lehet vágni az élt, amely összekapcsolja ezt a részfát a többi résszel. A cut_count változóval tartjuk nyilván az eltávolítható élek számát.

if size % 2 == 0 and node != 1:
    cut_count += 1

## DFS elindítása: A DFS-t a fa gyökércsomópontjából (1. csomópont) indítjuk el. Mivel ez a gyökér, nem vágjuk le a gyökérhez kapcsolódó élt.

dfs(1)

## Eredmény visszaadása: A végén visszaadjuk az eltávolítható élek számát, amelyet a cut_count változóban tartunk nyilván.

return cut_count

## Magyarázat:
Az 1-es és 3-as, valamint az 1-es és 6-os közötti élek eltávolításával megkapjuk a kívánt eredményt, ahol minden részfában páros számú csomópont található.