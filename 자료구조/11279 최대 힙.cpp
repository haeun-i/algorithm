#include <queue>
#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	priority_queue<int> q_list;

	int n;
	cin >> n;

	while (n--) {
		int instruct;
		cin >> instruct;
		if (q_list.empty() && instruct == 0) cout << 0 << '\n';
		else if (!q_list.empty() && instruct == 0) {
			cout << q_list.top() << '\n';
			q_list.pop();
		}
		else {
			q_list.push(instruct);
		}
	}
}