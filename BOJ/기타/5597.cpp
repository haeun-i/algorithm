#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	bool check[31] = { false };

	for (int i = 0; i < 28; i++) {
		int num;
		cin >> num;
		check[num] = true;
	}

	for (int i = 1; i < 31; i++) {
		if(!check[i]) cout << i << '\n';
	}

}