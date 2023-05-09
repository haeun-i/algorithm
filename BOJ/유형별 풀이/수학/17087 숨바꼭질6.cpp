#include <iostream>
#include <vector>
#include <cstdlib>
using namespace std;

int gcd(int  a, int b) {
	if (b == 0) return a;
	else return gcd(b, a % b);
}

int main() {
	
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	vector<int> length;

	int count, me;
	cin >> count >> me;
	
	for (int i = 0; i < count; i++) {
		int n;
		cin >> n;
		length.push_back(abs(me - n));
	}

	int g = length[0];
	for (int i = 0; i < length.size(); i++) {
		g = gcd(g, length[i]);
	}
	cout << g << '\n';
}