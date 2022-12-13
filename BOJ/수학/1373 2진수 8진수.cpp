#include <iostream>
#include <string>
#include <cmath>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	string s;
	cin >> s;
	
	if (s.size() % 3 == 1) {
		cout << s[0];
	}
	else if (s.size() % 3 == 2) {
		cout << (s[0] - '0') * 2 + s[1] - '0';
	}
	for (int i = s.size() % 3; i < s.size(); i+=3) {
		cout << (s[i] - '0') * 4 + (s[i + 1] - '0') * 2 + s[i + 2] - '0';
	}

}