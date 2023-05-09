#include <iostream>
#include <vector>
using namespace std;


// int tree[100001][1000001]; 
// 배열이 과하게 크다고 나올 때 -> vector로 만들어서 해결하기
vector<int> tree[100001];

int parent[100001] = { 0 };
int checked[100001] = { 0 };

void findparent(int x) {
	checked[x] = 1;

	for (int i = 0; i <= tree[x].size(); i++) {
		int next = tree[x][i];
		if (checked[i] == 0) {
			parent[next] = x;
			findparent(next);
		}
	}
}

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	int n;
	cin >> n;

	for (int i = 1; i <= n - 1; i++) {
		int a, b;
		cin >> a >> b;

		tree[a].push_back(b);
		tree[b].push_back(a);
	}

	findparent(1);

	for (int i = 2; i <= n; i++) {
		cout << parent[i] << '\n';
	}
}