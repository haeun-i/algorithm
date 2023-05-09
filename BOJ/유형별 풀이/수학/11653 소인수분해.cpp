#include <iostream>
using namespace std;

int main() {
	int n;
	cin >> n;
	int prime = 2;
	while (n != 1) {
		if (n % prime == 0) {
			cout << prime << "\n";
			n /= prime;
		}
		else prime++;
	}
}