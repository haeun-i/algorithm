#include <iostream>
#include <queue>
using namespace std;

int graph[1001][1001] = { 0 };
int checked[1001] = { 0 };
int n, m , start;

void dfs(int x) {
	checked[x] = 1;
	cout << x << " ";
	for (int i = 1; i <= n; i++) { // 정점이 1번부터 시작해서 n개를 돌아야 하므로
		if (graph[x][i] == 1 && checked[i] == 0) {
			dfs(i);
		}
	}
}

void bfs(int x) {
	queue<int> q;
	q.push(x);
	checked[x] = 1;
	cout << x << " ";

	while (!q.empty()) {
		x = q.front();
		q.pop();

		for (int i = 1; i <= n; i++) {
			if (graph[x][i] == 1 && checked[i] == 0) {
				q.push(i);
				checked[i] = 1;
				cout << i << " ";
			}
		}
	}
}



int main() {
	cin >> n >> m >> start;

	for (int i = 0; i < m; i++) {
		int a, b;
		cin >> a >> b;
		graph[a][b] = 1;
		graph[b][a] = 1;
	}

	dfs(start);
	cout << "\n";

	for (int i = 1; i <= n; i++) {
		checked[i] = 0;
	}

	bfs(start);
}