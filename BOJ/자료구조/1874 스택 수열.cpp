#include <iostream>
#include <stack>
#include <vector>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	int n;
	cin >> n;
	
	int max = 0;
	bool state = true;

	stack<int> num_list;
	vector<char> result_list;

	while (n--) {
		int num;
		cin >> num;
		if (max < num) {
			for (int i = max + 1; i <= num; i++) {
				num_list.push(i);
				result_list.push_back('+');
			}
			num_list.pop();
			result_list.push_back('-');
			max = num;
		}

		else {
			if (num_list.top() < num) {
				cout << "NO" << '\n';
				return 0;
			}
			else if (num_list.top() > num) {
				while (num_list.top() != num) {
						num_list.pop();
						result_list.push_back('-');
				}
			}
			else if (num_list.top() == num) {
					num_list.pop();
					result_list.push_back('-');
			}
		}
	
	}


	for (int i = 0; i < result_list.size(); i++) {
		cout << result_list[i] << '\n';
	}
}