#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool compare(const pair<int, int>& a, const pair<int, int>& b) {
	if (a.second == b.second) {
		return a.first < b.first;
	}
	return a.second < b.second;
}

int main() {
	int n;
	cin >> n;
	vector<pair<int, int>> room;
	for (int i = 0; i < n; i++) {
		pair<int, int> p;
		cin >> p.first >> p.second;
		room.push_back(p);
	}
	
	sort(room.begin(), room.end(), compare);
	
	int count = 1;
	int endTime = room[0].second;

	for (int i = 1; i < n; i++) {
		if (endTime <= room[i].first) {
			count++;
			endTime = room[i].second;
		}
	}

	cout << count << '\n';
}