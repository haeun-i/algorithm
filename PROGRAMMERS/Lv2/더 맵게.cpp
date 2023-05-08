#include <string>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;

    
    priority_queue<int, vector<int>, greater<int>> pq;
    for(int i : scoville){
        pq.push(i);
    }
    
    while(pq.size() > 1 && pq.top() < K){
        int f = pq.top();
        pq.pop();
        int s = pq.top();
        pq.pop();
        pq.push(f + (s*2));
        answer++;
    }
    
    if(pq.top() < K) return -1;
    return answer;
}