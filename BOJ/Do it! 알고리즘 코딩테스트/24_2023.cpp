#include <bits/stdc++.h>
using namespace std;

int n;

bool isPrime(int x) {
	if (x == 1) return false;
	for (int i = 2; i <= sqrt(x); i++) {
		if (x % i == 0) return false;
	}
	return true;
}

void dfs(int x, int d) {
	if (d == n) {
		if (isPrime(x)) cout << x << '\n';
		return;
	}

	for (int i = 1; i <= 9; i++) {
		if (d == 0) {
			if (isPrime(x + i)) {
				dfs(x + i, d + 1);
			}
		}
		else {
			int tmp = x * 10 + i;
			if (isPrime(tmp)) {
				dfs(tmp, d + 1);
			}
		}
		
	}

}
int main() {

	cin >> n;

	dfs(0, 0);
}