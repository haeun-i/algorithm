#include <bits/stdc++.h>
using namespace std;

vector<int> arr;
int dp1[100001] = { 0, };
int dp2[100001] = { 0, };

int main() {
	int n;
	cin >> n;

	int num;
	for (int i = 0; i < n; i++) {
		cin >> num;
		arr.push_back(num);
	}


	int mx = arr[0];
	dp1[0] = arr[0];
	for (int i = 1; i < n; i++) {
		dp1[i] = max(arr[i], dp1[i - 1] + arr[i]);
		mx = max(mx, dp1[i]);
	}

	dp2[n-1] = arr[n-1];
	for (int i = n-2; i >= 0; i--) {
		dp2[i] = max(arr[i], dp2[i + 1] + arr[i]);
	}

	for (int i = 1; i < n - 1; i++) {
		int tmp = dp1[i - 1] + dp2[i + 1];
		mx = max(tmp, mx);
	}


	cout << mx;

}