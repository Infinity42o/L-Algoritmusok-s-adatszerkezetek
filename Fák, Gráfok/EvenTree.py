#!/bin/python3

import math
import os
import random
import re
import sys

# Az evenForest függvény megvalósítása
def evenForest(t_nodes, t_edges, t_from, t_to):
    # Szomszédsági lista létrehozása a fához
    tree = {i: [] for i in range(1, t_nodes + 1)}
    
    # Élek hozzáadása a fához (kétirányú)
    for i in range(t_edges):
        u, v = t_from[i], t_to[i]
        tree[u].append(v)
        tree[v].append(u)
    
    # Az elágazott csomópontok és részfák méreteinek nyomon követésére
    visited = [False] * (t_nodes + 1)
    subtree_size = [0] * (t_nodes + 1)
    
    # Az eltávolítható élek számának inicializálása
    cut_count = 0
    
    # DFS függvény a részfák méretének kiszámításához és az érvényes vágások számolásához
    def dfs(node):
        nonlocal cut_count
        visited[node] = True
        size = 1  # Minden csomópont hozzájárul saját részfájának méretéhez
        
        for neighbor in tree[node]:
            if not visited[neighbor]:
                size += dfs(neighbor)
        
        # Ha a részfa mérete páros és nem az egész fa, elvághatjuk az élt
        if size % 2 == 0 and node != 1:
            cut_count += 1
        
        subtree_size[node] = size
        return size
    
    # DFS indítása a gyökércsomópontból (1. csomópont)
    dfs(1)
    
    return cut_count

# Bemenet beolvasása és a függvény meghívása
if __name__ == '__main__':
    t_nodes, t_edges = map(int, input().split())
    
    t_from = []
    t_to = []
    
    for _ in range(t_edges):
        f, t = map(int, input().split())
        t_from.append(f)
        t_to.append(t)
    
    result = evenForest(t_nodes, t_edges, t_from, t_to)
    print(result) 
