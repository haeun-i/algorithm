#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> num_list;
int binary(int target, int  start, int end) {
	int mid = (start + end) / 2;
	if (start > end) return -1;
	
	if (num_list[mid] == target) return mid;
	else if (num_list[mid] > target) return binary(start, mid - 1, target);
	else return binary(mid + 1, end, target);
}

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	int n;
	cin >> n;
	vector<int> num_list;

	for (int i = 0; i < n; i++) {
		int num;
		cin >> num;
		num_list.push_back(num);
	}

	sort(num_list.begin(), num_list.end());

	int m;
	cin >> m;
	for (int i = 0; i < m; i++) {
		int num2;
		cin >> num2;

		if (binary(num2, 0, num_list.size()-1) == -1) cout << "0 ";
		else cout << "1 ";
	}

}