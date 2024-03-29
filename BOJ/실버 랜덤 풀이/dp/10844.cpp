#include <bits/stdc++.h>
using namespace std;

long long arr[101][11] = { 0, };
int main() {
	int n;
	cin >> n;

	for (int i = 1; i <= 9; i++) {
		arr[1][i] = 1;
	}

	for (int i = 2; i <= n; i++) {
		arr[i][0] = arr[i - 1][1];
		for (int j = 1; j < 9; j++) {
			arr[i][j] = (arr[i - 1][j - 1] + arr[i - 1][j + 1]) % 1000000000;
		}
		arr[i][9] = arr[i - 1][8];
	}

	long long sum = 0;
	for (int i = 0; i <= 9; i++) {
		sum = (sum + arr[n][i]) % 1000000000;
	}
	cout << sum % 1000000000;
}