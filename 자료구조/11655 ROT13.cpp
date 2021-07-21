#include <iostream>
#include <string>
using namespace std;

int main() {
	
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	string s;
	getline(cin, s);

	for (int i = 0; i <= s.size(); i++) {
		int position = int(s[i]) - 97;

		if (s[i] >= 'A' && s[i] <= 'M') {
			s[i] += 13;
		}
		else if (s[i] >= 'N' && s[i] <= 'Z') {
			s[i] -= 13;
		}
		else if (s[i] >= 'a' && s[i] <= 'm') {
			s[i] += 13;
		}
		else if (s[i] >= 'n' && s[i] <= 'z') {
			s[i] -= 13;
		}
	}

	cout << s << "\n";

}