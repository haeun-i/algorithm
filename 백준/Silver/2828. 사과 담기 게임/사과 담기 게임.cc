#include <bits/stdc++.h>
using namespace std;

int main() {
	int n, m, j;
	cin >> n >> m >> j;

	int tmp = m;
	int result = 0;
	for (int i = 0; i < j; i++) {
		int loca;
		cin >> loca;

		if (loca > tmp) {
			// 끝을 tmp로 옮길 수 있도록 한다.
			result += (loca - tmp);
			tmp = loca;
			
		}
		else if (loca <= (tmp - m)) {
			result += (tmp - loca - m + 1);
			tmp = (loca + m - 1);
			
		}
	}
	cout << result;
}