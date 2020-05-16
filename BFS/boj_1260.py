from sys import stdin as std
from collections import deque

n, e, st = map(int, std.readline().split())
st -= 1
grid = [[0] * n for i in range(n)]
visited = [0] * n

for i in range(e):
    node_a, node_b = map(lambda x: x - 1, map(int, std.readline().split()))
    grid[node_a][node_b] = grid[node_b][node_a] = 1


def dfs(st, visited):
    print(st + 1, end = " ")
    visited[st] = 1

    for i in range(n):
        if grid[st][i] == 0:
            continue
        if visited[i] == 1:
            continue
        dfs(i, visited)


def bfs():
    q = deque()
    visited = [0] * n
    q.append(st)

    while(q):
        now = q.popleft()
        print(now + 1, end=" ")
        visited[now] = 1
        for i in range(n):
            if grid[now][i] == 0:
                continue
            if visited[i] == 1:
                continue
            q.append(i)
            visited[i] = 1

dfs(st, visited)
print()
bfs()