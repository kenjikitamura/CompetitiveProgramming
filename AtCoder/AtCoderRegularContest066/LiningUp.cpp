#include <stdio.h>
#include <algorithm>
#include <string.h>
#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

int MOD(long x) {
  return x % 1000000007;
}

int main() {
  int N; cin >> N;
  int n[N];
  int memo[N];
  for (int i = 0; i < N; i++) {
    n[i] = 0;
    memo[i] = 0;
  }
  for (int i = 0; i < N; i++) {
    cin >> n[i];
    memo[n[i]]++;
  }

  for (int i = N % 2 == 0 ? 1 : 0; i < N; i+= 2) {
    if (memo[i] != (i == 0 ? 1 : 2)) {
      cout << 0 << endl;
      return 0;
    }
  }
  long a = 1;
  for (int i = 0; i < N / 2; i++) {
    a = MOD(a * 2);
  }
  cout << a << endl;
}
