#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	string s;
	getline(cin, s);
	vector<string> s_vec;

	while (s.size() != 0) {
		s_vec.push_back(s);
		s = s.substr(1, s.size());
	}

	sort(s_vec.begin(), s_vec.end());
	for (int i = 0; i < s_vec.size(); i++) {
		cout << s_vec[i] << '\n';
	}
}