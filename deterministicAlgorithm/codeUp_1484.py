# 2차원 배열 시계 방향으로 채우기
def solution(n, m):
    arr = [[0] * m for i in range(n)]

    # 방향 설정. 여기선 시계방향
    # 세로
    dx = [0, 1, 0, -1]
    # 가로
    dy = [1, 0, -1, 0]
    # 시작 위치
    x = 0
    y = 0
    # 최초 방향
    dir = 0

    for i in range(n * m):
        arr[x][y] = i + 1
        # 그 다음 좌표가 범위를 벗어나거나, 0이 아닌수 (이미 차져 있는 상태)를 만났을 때
        if (x + dx[dir] < 0 or x + dx[dir] >= n or y + dy[dir] < 0 or y + dy[dir] >= m or arr[x + dx[dir]][y + dy[dir]] != 0) :
            dir += 1
        dir %= 4
        x += dx[dir]
        y += dy[dir]

    return arr

arr = solution(3, 4)

for i in range(len(arr)):
    for j in range(len(arr[0])):
        print(arr[i][j], end=' ')
    print()