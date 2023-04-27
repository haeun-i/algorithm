#include <string>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

string solution(string number, int k) {
    string answer = "";
    int idx = 0;
    while(1){
        for(int i = 0; i < number.size(); ++i){
            if(number[i] >= number[i+1]){
                answer += number[i];
            }
            else
                --k;           

            if(k == 0 && i != number.size()-1){
                for(int j = i+1; j < number.size(); ++j){
                    answer += number[j];
                }
                return answer;
            }
            else if(k == 0 && i == number.size()-1)
                return answer;
        }
        number = answer;
        answer = "";
    }

    return answer;
}