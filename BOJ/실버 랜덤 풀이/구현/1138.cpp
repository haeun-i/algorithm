#include <bits/stdc++.h>
using namespace std;

int graph[11] = { 0, };

int main() {
	int n;
	cin >> n;

	for (int i = 1; i <= n; i++) {
		int num;
		cin >> num;

		if (graph[num] == 0) graph[num] = i;
		else {
			int cnt = 0;
			int idx = 0;
			for (int j = 0; j < n; j++) {
				if (graph[j] == 0) cnt++; // Å« È½¼ö ¼¼±â
				if (j > num && graph[j] == 0 && cnt == num+1) {
					idx = j;
					break;
				}
			}
			graph[idx] = i;
		}
	}

	for (int i = 0; i < n; i++) {
		cout << graph[i] << " ";
	}
}