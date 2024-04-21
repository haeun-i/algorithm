from collections import deque

N, M, V = map(int, input().split())

adj = [[0] * (N + 1) for _ in range(N + 1)]
visited1 = [False] * (N + 1)
visited2 = [False] * (N + 1)

for _ in range(M):
    a, b = map(int, input().split())
    adj[a][b] = 1
    adj[b][a] = 1


def bfs():
    q = deque([V])
    visited1[V] = True

    while q:
        tmp = q.popleft()
        print(tmp, end=' ')

        for i in range(1, N + 1):
            if visited1[i] == False and adj[tmp][i] != 0:
                q.append(i)
                visited1[i] = True


def dfs(V):
    print(V, end=' ')
    for i in range(1, N + 1):
        if visited2[i] == False and adj[V][i] != 0:
            visited2[i] = True
            dfs(i)


visited2[V] = True
dfs(V)
print()
bfs()