#include <iostream>
#include <string>
#include <cmath>
using namespace std;

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	string s;
	int n;
	cin >> s >> n;

	long long int result = 0;
	for (int i = 0; i < s.size(); i++) {
		if (s[i] >= '0' && s[i] <= '9'){ 
			int num = s[i] - '0'; 
			result += num * pow(n, s.size() - i - 1);
		}
		else {
			int num = s[i] - 'A' + 10;
			result += num * pow(n, s.size() - i - 1);
		}
	}

	cout << result;
}