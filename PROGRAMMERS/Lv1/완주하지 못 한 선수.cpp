#include <string>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    string answer = "";
    
    map<string, int> m;
    for(string s : participant){
        m[s]++;
    }
    for(string s : completion){
        m[s]--;
    }
    
    for(auto i=m.begin(); i != m.end(); i++){
        if(i->second != 0) answer = i->first;
    }
    
    return answer;
}