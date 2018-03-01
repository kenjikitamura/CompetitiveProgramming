#include <stdio.h>
#include <algorithm>
#include <string.h>
#include <iostream>
#include <vector>
using namespace std;

int main() {
  long long N[3];
  cin >> N[0];
  cin >> N[1];
  cin >> N[2];
  sort(N, N + 3);
  if (N[2] % 2 == 0) {
    cout << 0 << endl;
    return 0;
  }
  cout << N[0] * N[1] << endl;
  return 0;
}
