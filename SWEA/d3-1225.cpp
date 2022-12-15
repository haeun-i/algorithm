#include <iostream>
#include <queue>
using namespace std;

int main() {
	queue<int> q;
	for (int i = 0; i < 8; i++) {
		int num;
		cin >> num;
		q.push(num);
	}

	while (q.back() != 0) {
		for (int i = 1; i <= 5; i++) {
			if (q.front() - i <= 0) {
				q.push(0);
				q.pop();
				break;
			}
			else q.push(q.front() - i);
			q.pop();
		}
	}

	for (int i = 0; i < 8; i++) {
		cout << q.front() << " ";
		q.pop();
	}

}