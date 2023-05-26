#include <bits/stdc++.h>
using namespace std;

int graph[101][101] = { 0, };
int visited[101] = { 0, };

int main() {
	int n;
	cin >> n;

	int a, b;
	cin >> a >> b;

	int m;
	cin >> m;

	for (int i = 0; i < m; i++) {
		int n1, n2;
		cin >> n1 >> n2;
		graph[n1][n2] = 1;
		graph[n2][n1] = 1;
	}

	queue<int> q;
	q.push(a);
	visited[a] = 0;

	while (!q.empty()) {
		int x = q.front();
		q.pop();

		for (int i = 1; i <= n; i++) {
			if (visited[i] == 0 && graph[x][i] == 1) {
				q.push(i);
				visited[i] = visited[x] + 1;
			}
		}
	}

	if (visited[b] == 0) cout << -1;
	else cout << visited[b];

}