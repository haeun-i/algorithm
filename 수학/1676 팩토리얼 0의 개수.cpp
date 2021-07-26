#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n, result = 0;
	cin >> n;

	for (int i = 5; i <= n; i *= 5) {
		result += (n / i);
	}
	cout << result;
}