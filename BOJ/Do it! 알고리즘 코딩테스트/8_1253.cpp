#include <bits/stdc++.h>
using namespace std;

int main() {
	int n;
	cin >> n;
 	vector<int> v;

	int cnt = 0;
	int num;
	for (int i = 0; i < n; i++) {
		cin >> num;
		v.push_back(num);
	}
	sort(v.begin(), v.end());

	for (int i = 0; i < n; i++) {
		int l = 0;
		int r = n - 1;
		while (l < r) {
			if (v[l] + v[r] == v[i]) {
				if (l != i && r != i) {
					cnt++;
					break;
				}
				else if(l == i) {
					l++;
				}
				else if (r == i) {
					r--;
				}
			}
			else if (v[l] + v[r] < v[i]) {
				l++;
			}else if(v[l] + v[r] > v[i]) {
				r--;
			}
		}
	}

	cout << cnt;

}