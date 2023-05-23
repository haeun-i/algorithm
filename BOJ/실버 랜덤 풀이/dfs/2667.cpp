#include <bits/stdc++.h>
using namespace std;

int graph[26][26] = { 0, };
int visited[26][26] = { 0, };
int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };

int cnt = 0;
void dfs(int y, int x) {
	cnt++;
	visited[y][x] = 1;
	for (int i = 0; i < 4; i++) { 
		int nx = x + dx[i];
		int ny = y + dy[i];
		if (!visited[ny][nx] && graph[ny][nx] == 1) dfs(ny, nx);
	}
}
int main() {
	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		string s;
		cin >> s;
		for (int j = 0; j < n; j++) {
			graph[i][j] = s[j] - '0';
		}
	}

	vector<int> result;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (!visited[i][j] && graph[i][j] == 1) {
				dfs(i, j);
				result.push_back(cnt);
				cnt = 0;
			}
		}
	}

	sort(result.begin(), result.end());
	cout << result.size() << '\n';
	for (int i = 0; i < result.size(); i++) {
		cout << result[i] << '\n';
	}
}