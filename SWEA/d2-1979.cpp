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
		int check[16] = { 0, };
		int n, k;
		cin >> n >> k;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cin >> graph[i][j];
			}
		}

		for (int i = 0; i < n; i++) {
			bool flag = false;
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				if (graph[i][j] == 1) {
					flag = true;
					cnt++;
				}
				else if (graph[i][j] == 0 && flag == true && j != n - 1) {
					flag = false;
					check[cnt]++;
					cnt = 0;
				}
			}
			check[cnt]++;
		}



		for (int i = 0; i < n; i++) {
			bool flag = false;
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				if (graph[j][i] == 1) {
					flag = true;
					cnt++;
				}
				else if (graph[j][i] == 0 && flag == true && j != n - 1) {
					flag = false;
					check[cnt]++;
					cnt = 0;
				}
			}
			check[cnt]++;
		}

		cout << "#" << test_case << " " << check[k] << endl;

	}
	return 0;//��������� �ݵ�� 0�� �����ؾ��մϴ�.
}