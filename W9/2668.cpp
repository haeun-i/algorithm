#include <iostream>
#include <cstring>
#include <vector>
#include <algorithm>
using namespace std;

int arr[101] = { 0 };
int visited[101] = { 0 };
vector<int> result;

void dfs(int current, int start) {
	if (visited[current]) {
		if (current == start) {
			result.push_back(start);
		}
	}
	else {
		visited[current] = 1;
		dfs(arr[current], start);
	}
}

int main() {

	int n;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> arr[i];
	}
		

	for (int i = 1; i <= n; i++) {
		memset(visited, 0, sizeof(visited));
		dfs(i, i);
	}

	// 결과 출력
	cout << result.size() << endl;
	sort(result.begin(), result.end());
	for (int i = 0; i < result.size(); i++)
		cout << result[i] << endl;

}