#include <iostream>
#include <vector>
#include <stack>
using namespace std;

/*
����ǥ����̶�?
ABC/+ => (B/C)+A
*/

int main() {
	int n;
	cin >> n;
	string s;
	cin >> s;

	vector<double> num_list;
	for (int i = 0; i < n; i++) {
		double num;
		cin >> num;
		num_list.push_back(num);
	}

	stack<double> cal;

	for (int i = 0; i < s.size(); i++) {
		if (s[i] == '+') {
			double n2 = cal.top();
			cal.pop();
			double n1 = cal.top();
			cal.pop();
			cal.push(n1 + n2);
		}
		else if (s[i] == '-') {
			double n2 = cal.top();
			cal.pop();
			double n1 = cal.top();
			cal.pop();
			cal.push(n1 - n2);
		}
		else if (s[i] == '*') {
			double n2 = cal.top();
			cal.pop();
			double n1 = cal.top();
			cal.pop();
			cal.push(n1 * n2);
		}
		else if (s[i] == '/') {
			double n2 = cal.top();
			cal.pop();
			double n1 = cal.top();
			cal.pop();
			cal.push(n1 / n2);
		}
		else {
			cal.push(num_list[(int)s[i] - 65]); // 'A'�� �ƽ�Ű�ڵ� ������ 65��.
		}
	}
	
	cout << fixed;
	cout.precision(2);
	cout << cal.top() << endl;
}