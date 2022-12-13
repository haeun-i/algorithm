#include <iostream>
#include <cstring>
using namespace std;

int prime[1000000];
int pn = 0;
bool check[1000001];
int n = 1000000;

void checking() {
	memset(check, false, sizeof(check));

	for (int i = 2; i <= n; i++) {
		if (check[i] == false) {
			prime[pn++] = i;
			for (int j = i + i; j <= n; j += i) {
				check[j] = true;
			}
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	checking();

 	while (1) {
		int num;
		cin >> num;
		if (num == 0) break;
		else {
			int result = 0;
			for (int i = 3; i < n; i++) {
				if (check[i] == false && check[num - i] == false) {
					result = i;
					cout << num << " = " << result << " + " << num - result << '\n';
					break;
				}
			}
			if(result == 0) cout << "Goldbach's conjecture is wrong." << '\n';
		}
	}
}