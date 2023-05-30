#include <bits/stdc++.h>
using namespace std;

int main() {
	int n;
	cin >> n;

	vector<int> w;
	for (int i = 0; i < n; i++) {
		int num;
		cin >> num;
		w.push_back(num);
	}

	sort(w.begin(), w.end());

	int mx = 0;
	for (int i = 0; i < w.size(); i++) {
		mx = max(mx, (int)(w[i] * (w.size() - i)));
	}
	cout << mx;
}