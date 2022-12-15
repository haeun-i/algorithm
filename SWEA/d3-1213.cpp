#include <iostream>
#include <string>
using namespace std;

int main() {
	string s1, s2;
	cin >> s1 >> s2;

	int cnt = 0;
	for (int i = 0; i+s1.size() <= s2.size(); i++) {
		string s_tmp = s2.substr(i, s1.size());
		if (s_tmp == s1) cnt++;
	}
	cout << cnt << endl;
}