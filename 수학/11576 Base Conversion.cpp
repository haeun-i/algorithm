#include <iostream>
#include <vector>
#include <stack>
#include <cmath>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int a, b, m;
	cin >> a >> b >> m;

	vector<int> a_list;
	for (int i = 0; i < m; i++) {
		int num;
		cin >> num;
		a_list.push_back(num);
	}

	int result = 0;
	for (int i = 0; i < m; i++) {
		result += a_list[i] * pow(a, m - i - 1);
	}

	stack<int> sta;
	while (result >= b) {
		sta.push(result % b);
		result = result / b;
	}
	sta.push(result);

	while (!sta.empty()) {
		cout << sta.top()<< " ";
		sta.pop();
	}


}