#include <string>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

int solution(string skill, vector<string> skill_trees) {
    int answer = 0;
    
    int rank = 0;
    int priority[26] = {0,};
    for(int i=0; i<skill.size(); i++){
        priority[skill[i]-65] = i+1;
    }
    
    for(int i=0; i<skill_trees.size(); i++){
        int tmp_pri = 1;
        string tmp = skill_trees[i];
        cout << tmp <<" ";
        bool flag = true;
        for(int i=0; i<tmp.size(); i++){
            cout << tmp_pri;
            if(tmp_pri >= priority[tmp[i]-65]){
                if(priority[tmp[i]-65] != 0) tmp_pri = max(tmp_pri, priority[tmp[i]-65]) + 1;
            }
            else {
                flag = false;
                break;
            }
        }
        if(flag) answer++;
        cout << "\n";
    }

    return answer;
}