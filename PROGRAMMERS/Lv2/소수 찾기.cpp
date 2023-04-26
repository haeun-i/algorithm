#include <string>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

bool isPrime(int n) {
    if (n < 2) return false;

    for (int i = 2; i <= sqrt(n); i++)
        if (n % i == 0) return false;
    return true;
}

int solution(string numbers) {
    int answer = 0;

    sort(numbers.begin(), numbers.end());

    string rev = numbers;
    reverse(rev.begin(), rev.end());
    isPrime(stoi(rev));
    set<int> num;
    do {
        string temp = "";
        for (int i = 0; i < numbers.size(); i++) {
            temp += numbers[i];
            num.insert(stoi(temp));
        }
    } while (next_permutation(numbers.begin(), numbers.end()));

    for (auto i = num.begin(); i != num.end(); i++) {
        if (isPrime(*i)) answer++;
    }

    return answer;
}