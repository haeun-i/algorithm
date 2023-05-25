#include <bits/stdc++.h>
using namespace std;

int main() {
	string s;
	cin >> s;

	int cnt = 1;
	int idx = 0;
	while (1) {
		string tmp = to_string(cnt);
		for (int i = 0; i < tmp.length(); i++) {
			if (tmp[i] == s[idx]) {
				idx++;
			}
		}

		if (idx == s.length()) {
			cout << cnt;
			break;
		}
		else cnt++;
	}

}