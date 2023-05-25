#include <bits/stdc++.h>
using namespace std;

int dp[1000001] = { 0, };

int main() {
	int n;
	cin >> n;


	for (int i = 2; i <= n; i++) {
		if (i % 2 == 0 && i % 3 == 0) {
			dp[i] = min(dp[i - 1], min(dp[i / 2], dp[i / 3])) + 1;
		}
		else if (i % 2 == 0) {
			dp[i] = min(dp[i / 2], dp[i - 1]) + 1;
		}
		else if (i % 3 == 0) {
			dp[i] = min(dp[i / 3], dp[i - 1]) + 1;
		}
		else dp[i] = dp[i - 1] + 1;

		cout << dp[i] << " ";
	}

	cout << dp[n];

}