#include <string>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    
    queue<int> q;
    for(int i=0; i<progresses.size(); i++){
        if((100-progresses[i]) % speeds[i] == 0){
           q.push((100-progresses[i]) / speeds[i]);
        }
        else{
             q.push((100-progresses[i]) / speeds[i] + 1);
        }
    }
    
    int cnt = 1;
    int front = 0;
    while(q.size() != 1){
        front = max(front, q.front());
        q.pop();
        if(q.front() <= front) cnt++;
        else {
            answer.push_back(cnt);
            front = 0;
            cnt = 1;
        }
    }
    answer.push_back(cnt);
    return answer;
}