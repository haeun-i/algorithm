#include <string>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

int solution(vector<vector<string>> clothes) {
    int answer = 1;
    map<string, int> m;
    
    for(vector<string> v : clothes){
        m[v[1]]++;
    }
    
    for(auto i = m.begin(); i != m.end(); i++){
        answer *= i->second + 1;
	}
    
    return answer - 1;
}