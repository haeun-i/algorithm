#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	int result = 0;

	int n, k;
	cin >> n >> k;
	
	vector<int> coin_list;

	for (int i = 0; i < n; i++) {
		int num;
		cin >> num;

		coin_list.push_back(num);
	}

	sort(coin_list.begin(), coin_list.end(), greater<int>());

	for (int i = 0; i < n; i++) {
			result += (k / coin_list[i]);
			k %= coin_list[i];
	}

	cout << result << endl;
}