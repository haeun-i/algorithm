#include <string>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    
    int one_arr[5] = {1, 2, 3, 4, 5};
    int two_arr[8] = {2, 1, 2, 3, 2, 4, 2, 5};
    int three_arr[10] = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    int one = 0;
    int two = 0;
    int three = 0;
    
    for(int i=0; i < answers.size(); i++){
        if(answers[i] == one_arr[i%5]) one++;
        if(answers[i] == two_arr[i%8]) two++;
        if(answers[i] == three_arr[i%10]) three++;
    }
    
    vector<pair<int, int>> v;
    v.push_back({one, 1});
    v.push_back({two, 2});
    v.push_back({three, 3});

    sort(v.begin(), v.end());
    int max = v[2].first;
    
    for(int i=0; i<3; i++){
        if(v[i].first == max) answer.push_back(v[i].second);
    }
    return answer;
}