#include <queue>
#include <iostream>
#include <vector>
using namespace std;

int main() {
	int n1, n2;
	cin >> n1 >> n2;

	queue<int> q;
	vector<int> v;

	for (int i = 1; i <= n1; i++) {
		q.push(i);
	}

	cout << "<";

	while (q.size() != 1) {
		for (int i = 1; i < n2; i++) {
			int n = q.front();
			q.pop();
			q.push(n);
		}
		cout << q.front() << ", ";
		q.pop();
	}

	cout << q.front() << ">";

}