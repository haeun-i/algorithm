#include<iostream>
#include <bits/stdc++.h>
using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;
	/*
	   ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
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

		//90��
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				tmp1[j][n - (i + 1)] = graph[i][j];
			}
		}

		//180��
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				tmp2[j][n - (i + 1)] = tmp1[i][j];
			}
		}

		//180��
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
	return 0;//��������� �ݵ�� 0�� �����ؾ��մϴ�.
}