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

void swap(int* a, int* b) { // 알고리즘 헤더에 있음..
	if (a > b) {
		int temp;
		temp = *a;
		*a = *b;
		*b = temp;
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int a, b;
	cin >> a >> b;

	swap(&a, &b);

	for (int i = a; i <= b; i++) {
		if (prime(i)) cout << i << '\n';
	}
}

