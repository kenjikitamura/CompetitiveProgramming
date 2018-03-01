#include <stdio.h>
#include <algorithm>
#include <string.h>
#include <iostream>
#include <vector>
using namespace std;

int main() {
  int N; cin >> N;

  for (int i = 1; i <= 10000000; i++) {
    int sum = i * (i + 1) / 2;
    if (sum < N) {
      continue;
    }
    int diff = sum - N;
    for (int j = 1; j <= i; j++) {
      if (j == diff) {
        continue;
      }
      cout << j << endl;
    }
    break;
  }
  return 0;
}
