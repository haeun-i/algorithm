#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;


	for (test_case = 1; test_case <= T; ++test_case)
	{
		int graph[15][15] = { 0, };

		int n, m;
		cin >> n >> m;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cin >> graph[i][j];
			}
		}

		int sum = 0;
		for (int i = 0; i <= n - m; i++) {

			for (int j = 0; j <= n - m; j++) {
				int tmp = 0;
				// 네모 영역 잡음
				for (int k = 0; k < m; k++) {
					for (int t = 0; t < m; t++) {
						tmp += graph[i + k][j + t];
					}
				}
				sum = max(tmp, sum);
			}

		}

		cout << "#" << test_case << " " << sum << endl;
	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}