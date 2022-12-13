#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
using namespace std;

int n, m;
int result = 0;
vector<int> graph[10001];
int checked[100001] = { 0 };
vector<pair<int, int>> result_arr;

void dfs(int x) {
	result++;
	checked[x] = 1;
	for (int i = 0; i < graph[x].size(); i++) {
		if (checked[graph[x][i]] != 1) {
			dfs(graph[x][i]);
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> n >> m;
	while (m--) {
		int a, b;
		cin >> a >> b;

		graph[b].push_back(a);
	}
	
	for (int i = 1; i <= n; i++) {
		result = 0;
		dfs(i);
		memset(checked, 0, sizeof(checked));
		result_arr.push_back(make_pair(result, i));
	}

	sort(result_arr.begin(), result_arr.end(), greater<>());

	for (int i = result_arr.size()-1; i >= 0; i--) {
		if (result_arr[0].first == result_arr[i].first) cout << result_arr[i].second << " ";
	}
	cout << '\n';
}