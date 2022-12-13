#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n, result = 1;
	cin >> n;

	for (int i = n; i >= 1; i--) {
		result *= i;
	}
	
	cout << result;
}