#include <iostream>
#include <string>
#include <stack>
#include <cmath>
using namespace std;

int main() {;
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int d;
	int c;
	cin >> d >> c;


	stack<int> sta;
	while (d >= c) {
		sta.push(d % c);
		d /= c;
	}
	sta.push(d);

	while (!sta.empty()) {
		if (sta.top() >= 10) {
			cout << char(sta.top()+55);
		}
		else cout << sta.top();
		sta.pop();
	}


}