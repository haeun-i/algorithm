#include <iostream>
#include <queue>
using namespace std;

int graph[1001][1001] = { 0 };
int checked[1001] = { 0 };
int n, m, start;

void dfs(int x) {
	checked[x] = 1;

	for (int i = 1; i <= n; i++) { 
		if (graph[x][i] == 1 && checked[i] == 0) {
			dfs(i);
		}
	}
}


int main() {
	cin >> n >> m;
	int result = 0;

	for (int i = 0; i < m; i++) {
		int a, b;
		cin >> a >> b;
		graph[a][b] = 1;
		graph[b][a] = 1;
	}
	
	for (int i = 1; i <= n; i++) {
		if (!checked[i]) {
			dfs(start);
			result++;
		}
	}

	cout << result;
}