#include <string>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

vector<string> split(string input, string delimiter) {
	vector<string> ret;
	long long pos = 0;
	string token = "";
    
	while ((pos = input.find(delimiter)) != string::npos) {
		token = input.substr(0, pos);
		ret.push_back(token);
		input.erase(0, pos + delimiter.length());
	}
	ret.push_back(input);
	return ret;
}
string solution(string s) {
    string answer = "";
    vector<string> s_arr = split(s, " ");
    vector<int> i_arr;
    for(string s : s_arr){
        i_arr.push_back(stoi(s));
    }
    
    cout << i_arr[0];
    sort(i_arr.begin(), i_arr.end());
    answer = to_string(i_arr[0]) + " " + to_string(i_arr[i_arr.size()-1]);
    
    return answer;
}