#include <bits/stdc++.h>
using namespace std;

int main() {
	string s;
	cin >> s;

	string result = "";
	int tmp = 0;
	bool flag = true;
	for (int i = 0; i < s.size(); i++) {
		
		if (s[i] == '.') {
			if (tmp % 4 == 0) {
				for (int j = 0; j < tmp / 4; j++) {
					result += "AAAA";
				}
				tmp = 0;
			}
			else if (tmp % 2 == 0) {
				for (int j = 0; j < tmp / 4; j++) {
					result += "AAAA";
				}
				tmp %= 4;
				for (int j = 0; j < tmp / 2; j++) {
					result += "BB";
				}
				tmp = 0;
			}
			else flag = false;
			result += ".";
		}
		else tmp++;
	}

	if (tmp % 4 == 0) {
		for (int j = 0; j < tmp / 4; j++) {
			result += "AAAA";
		}
		tmp = 0;
	}
	else if (tmp % 2 == 0) {
		for (int j = 0; j < tmp / 4; j++) {
			result += "AAAA";
		}
		tmp %= 4;
		for (int j = 0; j < tmp / 2; j++) {
			result += "BB";
		}
		tmp = 0;
	}
	else flag = false;


	if (flag) cout << result;
	else cout << -1;
}