#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	int n;
	cin >> n;
	vector<int> num_list;
	vector<int> sum_list;
	
	for (int i = 0; i < n; i++) {
		int num;
		cin >> num;
		num_list.push_back(num);
	}

	sort(num_list.begin(), num_list.end());
	
	for (int i = 0; i < n; i++) {
		int cal = num_list[i] * (n - i);
		sum_list.push_back(cal);
	}

	sort(sum_list.begin(), sum_list.end(), greater<int>());

	cout << sum_list[0] << endl;

	
}