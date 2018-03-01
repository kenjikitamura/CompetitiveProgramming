#include <stdio.h>
#include <algorithm>
#include <string.h>
#include <iostream>
#include <vector>
using namespace std;

int main() {
  int N; cin >> N;
  int K; cin >> K;
  vector<int> v;
  for (int i = 0; i < N; i++) {
    int value;
    cin >> value;
    v.push_back(value);
  }
  cout << N << endl;
}
