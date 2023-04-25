#include <string>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    int answer = 0;
    int idx = 0;
    int tmp = 0;
    queue<int> q;
    
    while(1){
        
        if(idx == truck_weights.size()){
            answer += bridge_length;  
            break;  
        }
        
        if(q.size() == bridge_length){
            tmp -= q.front();
            q.pop();
        }
        
        if(tmp + truck_weights[idx] <= weight){
            tmp += truck_weights[idx];
            q.push(truck_weights[idx]); 
            idx++;
        }else{
            q.push(0);
        }
        
        answer++;
    }
    
    
    
    return answer;
}