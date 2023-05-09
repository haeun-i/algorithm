#include <iostream>
#include <string>
#include <stack>
using namespace std;

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n;
	cin >> n;
	cin.ignore();

	for (int i = 1; i <= n; i++) {
		stack<char> s;
		string str;
		getline(cin, str);
		str += ' ';

		for (char e : str) {
			if (e == ' ') {
				while (!s.empty()) {
					cout << s.top();
					s.pop();
				}
				cout << e;
			}
			else s.push(e);
		}
		cout << '\n';
	}
	
}
