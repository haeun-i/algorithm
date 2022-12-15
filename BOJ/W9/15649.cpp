#include <iostream>
using namespace std;
int n, m;
bool checked[9] = { 0, };
int arr[9] = { 0, };

void dfs(int p) {
	if (p == m) {
		for (int i = 0; i < m; i++) {
			cout << arr[i] << " ";
		}
		cout << '\n';
		return;
	}

	for (int i = 1; i <= n; i++) {
		if (!checked[i]) {
			checked[i] = true;
			arr[p] = i;
			dfs(p + 1);
			checked[i] = false;
		}
	}

};
int main() {

	cin >> n >> m;

	dfs(0);
}