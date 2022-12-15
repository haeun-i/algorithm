#include <iostream>
using namespace std;

int gcd(int  a, int b) {
	if (b == 0) return a;
	else return gcd(b, a % b);
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int num;
	cin >> num;

	for (int i = 0; i < num; i++) {
		int a, b;
		cin >> a >> b;

		int g = gcd(a, b);
		cout << (a * b) / g << '\n';
	}
}