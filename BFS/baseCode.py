from sys import stdin as std

# n행 m열 grid
n = int(std.readline())
m = int(std.readline())
grid = [[0] * m for i in range(n)]
dist = [[0] * m for i in range(n)]
visited = [[False] * m for i in range(n)]

for i in range(n):
    grid[i] = list(map(int,  std.readline().split()))

qx = []
qy = []
stx, sty = 0, 0
dx = [-1, 0, 0, 1]
dy = [0, -1, 1, 0]
visited[stx][sty] = True

qx.append(stx);
qy.append(sty);
dist[stx][sty] = 0;
visited[stx][sty] = True;

while(qx):
    nowx = qx.pop(0)
    nowy = qy.pop(0)
    for i in range(4):
        nextx = nowx + dx[i]
        nexty = nowy + dy[i]
        if (nextx < 0 or nextx >= n or nexty < 0 or nexty >= m):
            continue
        if (grid[nextx][nexty] == 0):
            continue
        if (visited[nextx][nexty]):
            continue
        dist[nextx][nexty] = dist[nowx][nowy] + 1;
        visited[nextx][nexty] = True;
        qx.append(nextx);
        qy.append(nexty);

for i in range(n):
    for j in range(m):
        print(dist[i][j], end=' ')
    print()
