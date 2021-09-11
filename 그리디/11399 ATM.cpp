#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	int n, result = 0;
	cin >> n;
	vector<pair<int, int>> vec;
	vector<int> sum;
	
	pair<int, int> init_pair = make_pair(0, 0);
	vec.push_back(init_pair);

	for (int i = 1; i <= n; i++) {
		int num;
		cin >> num;
		pair<int, int> num_pair = make_pair(num, i);
		vec.push_back(num_pair);
	}
	sort(vec.begin(), vec.end());

	sum.push_back(0);

	for (int i = 1; i < vec.size(); i++) {
		int sum_now = 0;
		sum_now = sum[i - 1] + vec[i].first;
		sum.push_back(sum_now);
	}

	for (int i = 1; i < sum.size(); i++) {
		result += sum[i];
	}

	cout << result << endl;

}