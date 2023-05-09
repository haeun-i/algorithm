#include <iostream>
using namespace std;

long long result[101][10] = { 0 };

int calculate(int n) {
	int sum = 0;
	for (int i = 1; i <= 9; i++) {
		result[1][i] = 1;
	}
	result[1][0] = 0;

	for (int k = 2; k <= n; k++) {
		for (int p = 0; p <= 9; p++) {
			if (p == 0) result[k][p] = (result[k - 1][p + 1]) % 1000000000;
			else if (p == 9) result[k][p] = (result[k - 1][p - 1]) % 1000000000;
			else result[k][p] = (result[k - 1][p - 1] + result[k - 1][p + 1]) % 1000000000;
		}
	}

	for (int o = 0; o < 10; o++) {
		sum += result[n][o];
		sum %= 1000000000;
	}
	return sum;
}

int main() {
	int n;
	cin >> n;
	cout << calculate(n) << endl;
}