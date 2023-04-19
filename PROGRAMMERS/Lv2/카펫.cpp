#include <string>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
 
    int garo = 0;
    int sero = 0;
    
    int sum = brown + yellow;
    int idx = 1;
    
    for(int i=1; i<sum; i++){
        if(sum % idx == 0){
            garo = idx;
            sero = sum / idx;
            
            if((garo - 2) * (sero - 2) == yellow){
                break;
            }
        }
        idx++;
    }
    
    answer.push_back(max(garo, sero));
    answer.push_back(min(garo, sero));
    return answer;
}