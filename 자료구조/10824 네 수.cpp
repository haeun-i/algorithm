#include <iostream>
#include <string>
using namespace std;

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	string n1, n2, n3, n4;
	cin >> n1 >> n2 >> n3 >> n4;
	cout << stoll(n1 + n2) + stoll(n3 + n4) << '\n';
	
}