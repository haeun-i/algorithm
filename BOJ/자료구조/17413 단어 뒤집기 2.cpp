#include <iostream>
#include <string>
#include <stack>
#include <queue>
using namespace std;

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);


	stack<char> s;
	queue<char> q;
	bool state = true;  // true�� stack�� ���� ����, �ƴ� ��� queue�� ���� ����. 

	string str;
	getline(cin, str);
	str += ' ';

	for (char e : str) {
		if (state == true) {
			if (e == ' ') {
				while (!s.empty()) {
					cout << s.top();
					s.pop();
				}
				cout << e;
			}
			else if (e == '<') {
				while (!s.empty()) {
					cout << s.top();
					s.pop();
				}
				state = false;
				q.push(e);
			}
			else s.push(e);
		}
		else if (state == false) {
			if (e == '>') {
				while (!q.empty()) {
					cout << q.front();
					q.pop();
				}
				cout << e;
				state = true;
			}
			else q.push(e);
		}
	}
	cout << '\n';
}
