#include <bits/stdc++.h>
using namespace std;

vector<vector<int>> vec(1001);
int visited[1001] = { 0, };
int cnt = 0;
void dfs(int x) {
	visited[x] = 1;
	for (int i = 0; i < vec[x].size(); i++) {
		if (visited[vec[x][i]] == 0) {
			dfs(vec[x][i]);
		}
	}
}
int main(){
	int n, m;
	cin >> n >> m;


	for (int i = 0; i < m; i++) {
		int u, v;
		cin >> u >> v;

		vec[u].push_back(v);
		vec[v].push_back(u);
	}

	for (int i = 1; i <= n; i++) {
		if (visited[i] == 0) {
			cnt++;
			dfs(i);
		}
	}
	cout << cnt;
} 