#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main() {
	string q;
	cin >> q;

	stack<char> s;
	int len = q.length();
	int result = 0;

	for (int i = 0; i < len; i++) {
		if (q[i] == '(') s.push(q[i]);
		else if (q[i] == ')') {
			s.pop();
			if (q[i - 1] == '(') result += s.size();
			else {
				result++;
			}
		}
	}

	cout << result << endl;
}