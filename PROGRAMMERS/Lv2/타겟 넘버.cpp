#include <string>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

int global = 0;
int cnt = 0;

void dfs(vector<int> numbers, int tmp, int x, int depth) {
    tmp += x;
    depth++;
    if (depth == numbers.size()) {
        if (tmp == global) cnt++;
        return;
    }

    dfs(numbers, tmp, numbers[depth], depth);
    dfs(numbers, tmp, numbers[depth] * (-1), depth);
}



int solution(vector<int> numbers, int target) {
    int answer = 0;
    global = target;

    dfs(numbers, 0, numbers[0], 0);
    dfs(numbers, 0, numbers[0] * (-1), 0);
    answer = cnt;

    return answer;
}