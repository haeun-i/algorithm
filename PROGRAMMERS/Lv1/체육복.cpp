#include <string>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = 0;
    vector<int> students(n, 1);

    for (int i = 0; i < lost.size(); ++i) {
        students[lost[i] - 1]--;
    }
    for (auto re : reserve) students[re - 1]++;

 
    for (int i = 0; i < students.size(); i++) {
        if (students[i] == 0) {
            if (0 <= i && students[i - 1] == 2) {
                students[i - 1]--;
                students[i]++;
            }
            else if (i + 1 < students.size() && students[i + 1] == 2) {
                students[i + 1]--;
                students[i]++;
            }
        }
    }

    for (auto st : students)  if (st > 0) answer++;

    return answer;
}