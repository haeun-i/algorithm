import sys
sys.setrecursionlimit(10000)

T = int(input())

dy = [1, 0, -1, 0]
dx = [0, 1, 0, -1]


def dfs(y, x):
    visited[y][x] = 1

    for d in range(4):
        ny = y + dy[d]
        nx = x + dx[d]

        if ny < 0 or ny >= N or nx < 0 or nx >= M: continue
        if graph[ny][nx] == 1 and visited[ny][nx] == 0:
            dfs(ny, nx)


for t in range(T):
    M, N, K = map(int, input().split())
    graph = [[0] * M for _ in range(N)]
    visited = [[0] * M for _ in range(N)]
    cnt = 0

    for m in range(K):
        x, y = map(int, input().split())
        graph[y][x] = 1

    for i in range(N):
        for j in range(M):
            if graph[i][j] == 1 and visited[i][j] != 1:
                dfs(i, j)
                cnt += 1
    print(cnt)