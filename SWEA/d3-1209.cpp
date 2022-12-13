
#include <iostream>
#include <vector>
#include <algorithm>
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

		int graph[101][101] = { 0, };

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				cin >> graph[i][j];
			}
		}

		vector<int> sum_list;
		for (int i = 0; i < 100; i++) {
			int garo_sum = 0;
			for (int j = 0; j < 100; j++) {
				garo_sum += graph[i][j];
			}
			sum_list.push_back(garo_sum);
		}
		for (int i = 0; i < 100; i++) {
			int sero_sum = 0;
			for (int j = 0; j < 100; j++) {
				sero_sum += graph[j][i];
			}
			sum_list.push_back(sero_sum);
		}

		for (int i = 0; i < 100; i++) {
			int daegak_sum = 0;
			daegak_sum += graph[i][i];
			sum_list.push_back(daegak_sum);
		}

		for (int i = 0; i < 100; i++) {
			int daegak_sum2 = 0;
			daegak_sum2 += graph[i][99 - i];
			sum_list.push_back(daegak_sum2);
		}

		cout << "#" << test_case << " " << *max_element(sum_list.begin(), sum_list.end()) << endl;
	}
	return 0;//��������� �ݵ�� 0�� �����ؾ��մϴ�.
}