#include <iostream>
#include <stack>
using namespace std;

string calvps(string vps) {

	stack<char> s;
	for (int i = 0; i < vps.size(); i++) {
		if (vps[i] == '(') s.push(vps[i]);
		else if (vps[i] == ')') {
			if (s.empty()) return "NO";
			else { s.pop(); }
		}
	}

	if (s.size() != 0) return "NO";
	else return "YES";
}
int main() {
	int n;
	cin >> n;

	while (n--) {
		string vps;
		cin >> vps;

		cout << calvps(vps) << endl;
	}
}