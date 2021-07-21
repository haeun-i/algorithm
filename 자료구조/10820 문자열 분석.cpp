#include <iostream>
#include <string>
using namespace std;

int main() {
	
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	while (1) {
		string s;
		getline(cin, s);

		if (s.length() == 0) break;

		int small = 0, big = 0, num = 0, space = 0;

		for (char c : s) {
			if (c >= 48 && c <= 57) {
				num++;
			}
			else if (c >= 97 && c <= 122) {
				small++;
			}
			else if (c >= 65 && c <= 90) {
				big++;
			}
			else if (c == ' ') {
				space++;
			}
		}

		cout << small << " " << big << " " << num << " " << space << '\n';

	}
}