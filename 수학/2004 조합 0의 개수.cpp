#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	long long n, m, minus = 0;
	cin >> n >> m;
	minus = n - m;
	
	long long n2 = 0, n5 = 0, m2 = 0, m5 = 0, minus2 = 0, minus5 = 0;

	for (long long i = 2; i <= n; i *= 2) {
		n2 += (n / i);
	}
	for (long long i = 5; i <= n; i *= 5) {
		n5 += (n / i);
	}

	for (long long i = 2; i <= m; i *= 2) {
		m2 += (m / i);
	}
	for (long long i = 5; i <= m; i *= 5) {
		m5 += (m / i);
	}	

	for (long long i = 2; i <= minus; i *= 2) {
		minus2 += (minus / i);
	}
	for (long long i = 5; i <= minus; i *= 5) {
		minus5 += (minus / i);
	}

	cout << min(n2 - m2 - minus2, n5 - m5 - minus5);
}