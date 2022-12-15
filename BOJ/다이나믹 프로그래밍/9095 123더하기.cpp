#include <iostream>
using namespace std;

int cal[12] = { 0, };

int calculate(int n) {
	if (cal[n] > 0) return cal[n];
	if (n == 1) return 1;
	else if (n == 2) return 1;
	else if (n == 3) return 3;

	else {
		cal[n] = calculate(n - 1) + calculate(n - 2) + calculate(n - 3);
		return cal[n];
	}
}

int main() {
	int n;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		int num;
		cin >> num;
		cout << calculate(num) << endl;
	}
}