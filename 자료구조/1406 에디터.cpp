#include <iostream>
#include <stack>
using namespace std;

int main() {
	string s;
	int n;
	cin >> s >> n;

	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);


	stack<char> left, right;

	for (char e : s) {
		left.push(e);
	}


	for (int i = 1; i <= n; i++) {
		char s2;
		cin >> s2;

		if (s2 == 'L') {
			if (!left.empty()) {
				right.push(left.top());
				left.pop();
			}
		}
		else if (s2 == 'D') {
			if (!right.empty()) {
				left.push(right.top());
				right.pop();
			}
		}
		else if (s2 == 'B') {
			if (!left.empty()) {
				left.pop();
			}
		}
		else if (s2 == 'P') {
			char c;
			cin >> c;
			left.push(c);
		}
	}

	while (!left.empty()) {
		right.push(left.top());
		left.pop();
	}


	while (!right.empty()) {
		cout << right.top();
		right.pop();
	}
}