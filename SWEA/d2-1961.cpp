#include<iostream>
#include <bits/stdc++.h>
using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;
	/*
	   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
	*/
	for (test_case = 1; test_case <= T; ++test_case)
	{
		int graph[16][16] = { 0, };
		int tmp1[16][16] = { 0, };
		int tmp2[16][16] = { 0, };
		int tmp3[16][16] = { 0, };

		int n;
		cin >> n;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cin >> graph[i][j];
			}
		}

		//90도
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				tmp1[j][n - (i + 1)] = graph[i][j];
			}
		}

		//180도
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				tmp2[j][n - (i + 1)] = tmp1[i][j];
			}
		}

		//180도
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				tmp3[j][n - (i + 1)] = tmp2[i][j];
			}
		}
		cout << "#" << test_case << endl;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cout << tmp1[i][j];
			}
			cout << " ";
			for (int j = 0; j < n; j++) {
				cout << tmp2[i][j];
			}
			cout << " ";
			for (int j = 0; j < n; j++) {
				cout << tmp3[i][j];
			}
			cout << endl;
		}

	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}