#include <bits/stdc++.h>
using namespace std;

int main() {
	int n;
	cin >> n;

	int l = 1;
	int r = 2;
	int sum = 3;

	int cnt = 0;
	while (r <= n) {
		if (sum == n) {
			cnt++;
			sum -= l;
			l++;
		}
		else if (sum < n) {
			r++;
			sum += r;
		}
		else if (sum > n) {
			sum -= l;
			l++;
		}

	}

	if (n == 1 || n == 2) cnt = 1;
	if (n == 3) cnt = 2;

	cout << cnt;
}