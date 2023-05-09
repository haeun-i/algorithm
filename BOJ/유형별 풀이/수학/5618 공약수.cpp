#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	int n;
	cin >> n;

	vector<int> num_list;
	for (int i = 0; i < n; i++) {
		int num;
		cin >> num;
		num_list.push_back(num);
	}
	
	sort(num_list.begin(), num_list.end());

	if (num_list.size() == 2) {
		for (int i = 1; i <= num_list[0]; i++) {
			if (num_list[0] % i == 0 && num_list[1] % i == 0) cout << i << endl;
		}
	}
	else if (num_list.size() == 3) {
		for (int i = 1; i <= num_list[0]; i++) {
			if (num_list[0] % i == 0 && num_list[1] % i == 0 && num_list[2] % i == 0) cout << i << endl;
		}
	}

}