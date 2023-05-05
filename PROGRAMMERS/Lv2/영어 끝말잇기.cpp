#include <string>
#include <vector>
#include <iostream>
#include <bits/stdc++.h>
using namespace std;

vector<int> solution(int n, vector<string> words) {
    vector<int> answer;

    int i;
    map<string, int> m;
    m[words[0]]++;
    for(i=1; i<words.size(); i++){
        cout << i << endl;
        
        if(words[i-1].back() != words[i][0]) break;
        
        if(m[words[i]] != 0) break;
        else m[words[i]]++;
    }
    

           
    if(i == words.size()){
        answer.push_back(0);
        answer.push_back(0);
    }else{
        if((i+1)%n == 0) {
            answer.push_back(n);
            answer.push_back(((i+1)/n));
        }
        else {
            answer.push_back((i+1)%n);
            answer.push_back((i+1)/n + 1);
        }
        
        
    }
    
    return answer;
}