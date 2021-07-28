#include <iostream>
using namespace std;

int gcd(int  a, int b) {
	if (b == 0) return a;
	else return gcd(b, a % b);
}

int main() {
	
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int f_num;
	cin >> f_num;
	
	for (int k = 0; k < f_num; k++) {
		int n; 
		cin >> n;
	
		long long int result = 0;
		int* arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			int num;
			cin >> num;
			arr[i] = num;
		}

		for (int i = 0; i < n ; i++) {
			for (int j = i + 1; j < n; j++) {
				result += gcd(arr[i], arr[j]);
			}
		}

		cout << result << '\n';
	}
}