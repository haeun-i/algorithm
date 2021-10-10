#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	vector<int> house;
	vector<int> result;

	for (int i = 0; i < n; i++) {
		int num;
		cin >> num;
		house.push_back(num);
	}

	sort(house.begin(), house.end());
	int small = 1;
	int big = house[n - 1] - house[0];


	while (small <= big) {
		int mid = (small + big) / 2;
		int prev = house[0];
		int count = 1; // 해당 거리일 때 사용 된 공유기의 수

		for (int i = 1; i < n; i++) {
			if (house[i] - prev >= mid) {
				count++;
				prev = house[i];
			}
		}

		if (count >= m) {
			result.push_back(mid);
			small = mid + 1;
		}
		else {
			big = mid - 1;
		}
	}


	cout << *max_element(result.begin(), result.end());



}