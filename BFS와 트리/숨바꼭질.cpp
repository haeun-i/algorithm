#include <iostream>
#include <queue>
using namespace std;
bool checked[100001] = { 0 };
int dist[100001] = { 0 };

int main() {

	int subin, sister;
	cin >> subin >> sister;

	queue<int> q;
	q.push(subin);

	while (!q.empty()) {
		int now = q.front();
		q.pop();

		if (now == sister) {
			break;
		}
		if (now - 1 >= 0) {
			if (checked[now - 1] == 0) {
				q.push(now - 1);
				checked[now - 1] = 1;
				dist[now - 1] = dist[now] + 1;
			}
		}

		if (now + 1 < 100001) {
			if (checked[now + 1] == 0) {
				q.push(now + 1);
				checked[now + 1] = 1;
				dist[now + 1] = dist[now] + 1;
			}
		}
		if (now * 2 < 100001) {
			if (checked[now * 2] == 0) {
				q.push(now * 2);
				checked[now * 2] = 1;
				dist[now * 2] = dist[now] + 1;
			}
		}
	}

	cout << dist[sister];
}