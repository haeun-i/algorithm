#include<iostream>
#include <bits/stdc++.h>
using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;
	for (test_case = 1; test_case <= T; ++test_case)
	{
		int n, m;
		cin >> n >> m;

		vector<int> v1;
		vector<int> v2;
		int num;
		for (int i = 0; i < n; i++) {
			cin >> num;
			v1.push_back(num);
		}
		for (int i = 0; i < m; i++) {
			cin >> num;
			v2.push_back(num);
		}

		int sum = 0;
		if (n > m) {
			for (int i = 0; i < n - m; i++) {
				int tmp = 0;
				for (int j = 0; j < m; j++) {
					tmp += v1[j + i] * v2[j];
				}
				sum = max(sum, tmp);
			}
		}
		else {
			for (int i = 0; i <= m - n; i++) {
				int tmp = 0;
				for (int j = 0; j < n; j++) {
					tmp += v2[j + i] * v1[j];
				}
				sum = max(sum, tmp);
			}
		}

		cout << "#" << test_case << " " << sum << endl;
	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}