from sys import stdin as std

def dfs(nowx, nowy):
    global visited, grid, n, m
    dx = [0, 0, -1, 1]
    dy = [1, -1, 0, 0]
    for i in range(4):
        nextx = nowx + dx[i]
        nexty = nowy + dy[i]
        if (nextx < 0 or nextx >= n or nexty < 0 or nexty >= m):
            continue
        if (visited[nextx][nexty]):
            continue
        if (grid[nextx][nexty] == 0):
            continue
        visited[nextx][nexty] = True
        if (dist[nextx][nexty] == 0):
            dist[nextx][nexty] = dist[nowx][nowy] + 1
        else:
            dist[nextx][nexty] = min(dist[nowx][nowy] + 1, dist[nextx][nexty])
        dfs(nextx, nexty)
        visited[nextx][nexty] = True

n = int(std.readline())
m = int(std.readline())
visited = [[False] * m for i in range(n)]
grid = [[0] * m for i in range(n)]
dist = [[0] * m for i in range(n)]
for i in range(n):
    grid[i] = list(map(int, std.readline().split()))

visited[0][0] = True
dist[0][0] = 0
dfs(0, 0)

for i in range(n):
    for j in range(m):
        print(dist[i][j], end=' ')
    print()
