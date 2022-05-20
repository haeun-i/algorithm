#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	cin >> n;
	vector<double> q;

	for (int i = 0; i < n; i++) {
		double num;
		cin >> num;
		q.push_back(num);
	}

	double max = *max_element(q.begin(), q.end());
	double sum = 0;

	for (int i = 0; i < q.size(); i++) {
		sum += q[i] / max * 100;
	}
	
	cout << sum / n;

}