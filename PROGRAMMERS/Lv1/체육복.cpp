#include <string>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

int arr[10001] = { 0, };
int main() {
    int answer = 0;
    int n = 15;

    arr[1] = 1;
    for (int i = 2; i <= n; i++) {
        arr[i] = arr[i - 1] + i;
    }

    int l = 1;
    int r = n;

    while (l != r) {
        if (arr[r] - arr[l] > n) {
            r--;
        }
        else if (arr[r] - arr[l] < n) {
            l++;
        }
        else if (arr[r] - arr[l] == n) {
            answer++;
            l++;
        }
    }

    return answer;
}