#include <iostream>
using namespace std;

long long fibonacci_arr[91] = { 0 };

long long fibonacci(int n) {

	if (n == 0) return 0;
	else if (n == 1) return 1;
	else if (n == 2) return 1;
	else if (fibonacci_arr[n] != 0) return fibonacci_arr[n];
	else {
		fibonacci_arr[n] = fibonacci(n - 1) + fibonacci(n - 2);
		return fibonacci_arr[n];
	}
}
int main() {
	int n;
	cin >> n;

	cout << fibonacci(n);
}