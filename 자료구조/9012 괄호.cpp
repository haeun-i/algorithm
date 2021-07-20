#include <stack>
#include <iostream>
using namespace std;

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int num;
	cin >> num;

	for (int i = 1; i <= num; i++) {
		stack<char> s;
		bool result = true;

		string str;
		cin >> str;
		
		for (char e : str) {
			if (e == '(') s.push(e);
			else if (e == ')') {
				if (!s.empty()) {
					s.pop();
				}
				else result = false;
			}
		}
		if (!s.empty()) result = false;

		if (result == true) cout << "YES" << '\n';
		else cout << "NO" << '\n';
	}

}