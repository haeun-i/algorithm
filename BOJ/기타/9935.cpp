#include <bits/stdc++.h>
using namespace std;

int main() {
	string str, bomb;
	cin >> str >> bomb;

	stack<char> s;
	int start_idx = 0;
	int end_idx = 0;
	for (int i = 0; i < str.size(); i++) {
		s.push(str[i]);
		if (s.size() >= bomb.size() && str[i] == bomb.back()) {
			string tmp = "";
			for (int i = 0; i < bomb.size(); i++) {
				tmp += s.top();
				s.pop();
			}
			reverse(tmp.begin(), tmp.end());
			
			if (tmp != bomb) {
				for (int i = 0; i < bomb.size(); i++) {
					s.push(tmp[i]);
				}
			}
		}
	}
	
	if (s.empty()) { cout << "FRUJA"; }
	else {
		string tmp = "";
		while (!s.empty()) {
			tmp += s.top();
			s.pop();
		}
		reverse(tmp.begin(), tmp.end());
		cout << tmp;
	}


}