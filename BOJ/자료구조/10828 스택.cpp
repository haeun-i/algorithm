#include <stack>
#include <iostream>
#include <string>
using namespace std;

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	
	stack<int> s; // stack 기본 선언 - stack<자료형>
	int num;
	cin >> num;
	for (int i = 1; i <= num; i++) {

		string str;
		cin >> str;

		if (str == "push") {
			int n;
			cin >> n;
			s.push(n);
		}
		else if (str == "pop") {
			if (s.empty()) cout << "-1\n";
			else {
				cout << s.top() << "\n";
				s.pop();
			}
		}
		else if (str == "size") {
			cout << s.size() << "\n";
		}
		else if (str == "empty") {
			cout << s.empty() ? 1 : 0;
			cout << "\n";
		}
		else if (str == "top") {
			if (s.empty()) cout << "-1\n";
			else cout << s.top() << "\n";
		}
	}
	
}