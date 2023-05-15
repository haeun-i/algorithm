#include <iostream>
#include <bits/stdc++.h>
using namespace std;

vector<string> split(string str, char c) {
	string word;
	istringstream iss(str);
	vector<string> arr;
	while (getline(iss, word, c)) {
		arr.push_back(word);
	}
	return arr;
}

vector<int> tominus;

int eval(string str) {

	int result = 0;
	// 더하기 입력하는 경우
	if (str.find('+') != string::npos) {
		vector<string> toplus = split(str, '+');
		for (string s : toplus) {
			result += stoi(s);
		}
	}

	if (result == 0) return stoi(str);
	else return result;
}
int main() {
	string s;
	cin >> s;

	vector<string> minus = split(s, '-');

	int result = eval(minus[0]);
	for (int i = 1; i < minus.size(); i++) {
		result -= eval(minus[i]);
	}

	cout << result;
}