#include <iostream>
using namespace std;

bool prime(int n) {
	if (n < 2) return false;
	for (int i = 2; i * i <= n; i++) {
		if (n % i == 0) {
			return false;
		}
	}
	return true;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int num, result = 0;
	cin >> num;

	for (int i = 0; i < num; i++) {
		int n;
		cin >> n;
		if (prime(n)) result++;
	}

	cout << result;

}