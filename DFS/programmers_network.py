def dfs(st, n, computers, visited):
    visited[st] = True
    for i in range(n):
        if (visited[i]):
            continue
        if (computers[st][i] == 0):
            continue
        visited[i] = True
        dfs(i, n, computers, visited)


def solution(n, computers):
    answer = 0
    visited = [False] * n
    for i in range(n):
        if visited[i]:
            continue
        dfs(i, n, computers, visited)
        answer += 1
    return answer