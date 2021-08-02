#include <iostream>
#include <algorithm>
using namespace std;

int arr[1000001] = { 0, };

int make_one(int n) {
	if (arr[n] > 0) return arr[n];
	else if (n == 1) return 0;
	else {
		arr[n] = 1 + make_one(n - 1);
		if (n % 2 == 0) {
			int temp = 1 + make_one(n / 2);
			if (arr[n] > temp) arr[n] = temp;
		}
		if (n % 3 == 0) {
			int temp = 1 + make_one(n / 3);
			if (arr[n] > temp) arr[n] = temp;
		}
		return arr[n];
	}
}

int main() {
	int n;
	cin >> n;
	cout << make_one(n);
}