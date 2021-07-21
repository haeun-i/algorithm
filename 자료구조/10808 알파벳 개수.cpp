#include <iostream>
#include <string>
using namespace std;

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	string s;
	int t[26] = { 0, };

	getline(cin, s);
	for (int i = 0; i < s.size(); i++) {
		int position = int(s[i]) - 97;
		t[position]++;
	}

	for (int i = 0; i <= 25; i++) {
		cout << t[i] << " ";
	}
	cout << "\n";

}