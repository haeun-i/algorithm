#include <iostream>
using namespace std;

int tyle[1001] = { 0, };

int tyle_cal(int n) {
	if (tyle[n] > 0) return tyle[n];
	if (n == 1) return 1;
	else if (n == 2) return 3;
	else {
		tyle[n] = (tyle_cal(n - 1) + tyle_cal(n - 2) + tyle_cal(n - 2)) % 10007;
		return tyle[n];
	}
}

int main() {
	int n;
	cin >> n;
	cout << tyle_cal(n);
}