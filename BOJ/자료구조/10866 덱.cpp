#include <deque>
#include <iostream>
#include <string>
using namespace std;

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	deque<int> d; // stack 기본 선언 - stack<자료형>
	int num;
	cin >> num;
	for (int i = 1; i <= num; i++) {

		string str;
		cin >> str;

		if (str == "push_front") {
			int n;
			cin >> n;
			d.push_front(n);
		}
		else if (str == "push_back") {
			int n;
			cin >> n;
			d.push_back(n);
		}
		else if (str == "pop_front") {
			if (d.empty()) cout << "-1\n";
			else {
				cout << d.front() << "\n";
				d.pop_front();
			}
		}
		else if (str == "pop_back") {
			if (d.empty()) cout << "-1\n";
			else {
				cout << d.back() << "\n";
				d.pop_back();
			}
		}
		else if (str == "size") {
			cout << d.size() << "\n";
		}
		else if (str == "empty") {
			cout << d.empty() ? 1 : 0;
			cout << "\n";
		}
		else if (str == "front") {
			if (d.empty()) cout << "-1\n";
			else cout << d.front() << "\n";
		}
		else if (str == "back") {
			if (d.empty()) cout << "-1\n";
			else cout << d.back() << "\n";
		}
	}

}