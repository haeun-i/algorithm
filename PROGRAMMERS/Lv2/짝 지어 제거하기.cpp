#include <iostream>
#include <string>
#include <bits/stdc++.h>
using namespace std;

int solution(string s){
    int answer = 0;
    stack<char> ss;
    
    for(int i=0; i<s.length(); i++){
        if(!ss.empty() && ss.top() == s[i]) ss.pop();
        else ss.push(s[i]);
    }
    if(ss.empty()) answer = 1;

    return answer;
}