#include <iostream>
using namespace std;
int n, m;
bool checked[9] = { 0, };
int arr[9] = { 0, };

void dfs(int p, int num) {
	if (p == m) {
		for (int i = 0; i < m; i++) {
			cout << arr[i] << " ";
		}
		cout << '\n';
		return;
	}

	for (int i = num; i <= n; i++) {
		if (!checked[i]) {
			checked[i] = true;
			arr[p] = i;
			dfs(p + 1, i + 1);
			checked[i] = false;
		}
	}

};
int main() {

	cin >> n >> m;

	dfs(0, 1);
}