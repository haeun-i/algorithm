#include <iostream>
using namespace std;

int graph[101][101] = { 0 };
int checked[101] = { 0 };
int result = 0;
int t, n;

void dfs(int x) {
	result++;
	checked[x] = 1;

	for (int i = 1; i <= t; i++) {
		if (graph[x][i] == 1 && checked[i] == 0) {
			dfs(i);
		}
	}
}

int main() {

	cin >> t >> n;

	while (n--) {
		int a, b;
		cin >> a >> b;
		graph[a][b] = 1;
		graph[b][a] = 1;
	}

	dfs(1);

	cout << result - 1 << endl;

}