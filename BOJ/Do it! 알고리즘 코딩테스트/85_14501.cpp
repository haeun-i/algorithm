#include <bits/stdc++.h>
using namespace std;

int arr[16] = { 0, };
int main() {
	int n;
	cin >> n;

	vector<int> t_arr;
	vector<int> p_arr;

	for (int i = 0; i < n; i++) {
		int n1, n2;
		cin >> n1 >> n2;

		t_arr.push_back(n1);
		p_arr.push_back(n2);
	}

	for (int i = n - 1; i >= 0; i--) {
		if (i + t_arr[i] <= n) {
			// 할 수 있음
			arr[i] = max(arr[i + t_arr[i]] + p_arr[i], arr[i + 1]);
		}
		else {
			arr[i] = arr[i + 1];
		}
	}

	cout << arr[0];

}