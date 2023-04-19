#include <string>
#include <vector>
#include <bitset>
#include <bits/stdc++.h>
using namespace std;

int solution(int n) {
    int answer = 0;
    int idx = n + 1;
    int cnt = 0;
    
    while(n > 0){
        if(n%2 == 1){
            cnt++;
        } 
        n /= 2;
    }
    while(1){
        int tmp = idx;
        int tmp_cnt = 0;
        while(tmp > 0){
            if(tmp % 2 == 1){
                tmp_cnt++;
            } 
            if(tmp_cnt > cnt) break;
            tmp /= 2;
        }
        if(tmp_cnt == cnt) {
            answer = idx;
            break;
        }
        idx++;
    }

    return answer;
}