#include <bits/stdc++.h>
using namespace std;

int sum[100001] = { 0, };
int main() {

	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	int n, m;
	cin >> n >> m;

	vector<int> arr;
	for (int i = 0; i < n; i++) {
		int num;
		cin >> num;
		arr.push_back(num);
	}

	sum[1] = arr[0];
	for (int i = 2; i <= n; i++) {
		sum[i] = sum[i - 1] + arr[i - 1];
	}

	for (int i = 0; i < m; i++) {
		int a, b;
		cin >> a >> b;
		cout << sum[b] - sum[a-1] << '\n';
	}
}