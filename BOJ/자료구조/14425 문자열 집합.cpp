#include <iostream>
#include <set>
using namespace std;

int main() {
	int n, m;
	cin >> n >> m;

	set<string> s_list;
	while (n--) {
		string s;
		cin >> s;
		s_list.insert(s);
	}

	int result = 0;

	while (m--) {
		string temp;
		cin >> temp;
		if (s_list.find(temp) != s_list.end()) result++;
	}

	cout << result << '\n';
}