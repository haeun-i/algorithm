#include <iostream>
using namespace std;

long long func(long long a, long long b, long long c) {
    if (b > 1) {
        long long result = func(a, b / 2, c);
        if (b % 2) return ((result * result) % c * a) % c;
        else return (result * result) % c;
    }
    else return a;
}

int main() {
    long long a, b, c;
    cin >> a >> b >> c;

    long long result = func(a % c, b, c);
    cout << result << '\n';
}
