#include <bits/stdc++.h>
using namespace std;

map<string, int> word;

bool cmp(string a, string b) {
	if (word[a] == word[b]) {
		if (a.size() == b.size()) {
			return a < b;
		}
		return a.size() > b.size();
	}
	return word[a] > word[b];
}
int main() {

	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int n, m;
	cin >> n >> m;
	
	vector<string> ini;

	for (int i = 0; i < n; i++) {
		string s;
		cin >> s;

		if (s.size() >= m) {
			word[s]++;
			if(word[s] == 1) ini.push_back(s);
		}
	}

	sort(ini.begin(), ini.end(), cmp);

	for (int i = 0; i < ini.size(); i++) {
		cout << ini[i] << '\n';
	}


}