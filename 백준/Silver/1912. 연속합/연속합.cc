#include <bits/stdc++.h>
using namespace std;

vector<int> arr;
int dp[100001] = { 0, };

int main() {
	int n;
	cin >> n;

	int num;
	for (int i = 0; i < n; i++) {
		cin >> num;
		arr.push_back(num);
	}

	dp[0] = arr[0];
	for (int i = 1; i < n; i++) {
		dp[i] = max(arr[i], dp[i - 1] + arr[i]);
	}

	cout << *max_element(&dp[0], dp + n);

}