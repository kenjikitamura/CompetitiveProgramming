#include <stdio.h>
#include <algorithm>
#include <string.h>
#include <iostream>
#include <vector>
using namespace std;

//debug
#define dump(x)  cerr << #x << " = " << (x) << endl;
#define debug(x) cerr << #x << " = " << (x) << " (L" << __LINE__ << ")" << " " << __FILE__ << endl;

long long LONG2_MAX = 9223372036854775807;

long long min(long long a, long long b) {
  return a < b ? a : b;
}

long long min2(int magic, int N, int index, vector<long long> a) {
  long long m = LONG2_MAX;
  int i = index - magic;
  if (i < 0) {
    i += N;
  }
  do {
    //debug(magic);
    if (i == N) {
      i = 0;
    }
    m = min(m, a[i]);
    i++;
  } while(i != (index + 1));
  return m;
}

long long solve(int N, long long x, vector<long long> a) {
  long long allMin = LONG2_MAX;
  for (int magic = 0; magic < N; magic++) {
    long long sum = 0;
    long long memo[N];
    for (int i = 0; i < N ;i++) {
      memo[i] = 0;
    }

    for (int i = 0; i < N; i++) {
      long long m = LONG2_MAX;;
      if (magic == 0) {
        m = a[i];
      } else {
        long long prev = magic -1;
        if (memo[prev] == 0) {
          m = min2(magic, N, prev, a);
          memo[prev] = m;
        } else {
          m = memo[prev];
        }
        m = min(m, a[i]);
      }
      //debug(m);
      sum += m;
    }
    sum += x * magic;
    //debug(sum);
    allMin = min(allMin, sum);
  }
  return allMin;
}

int main() {

  /*
  int N;
  cin >> N;
  int x;
  cin >> x;
  vector<long long> list(N);
  for (int i = 0; i < N; i++) {
    cin >> list[i];
  }
  cout << solve(N, x, list)  << endl;
  */

  // /*
  {
  int N = 2;
  int x = 10;
  vector<long long> list;
  list.push_back(1);
  list.push_back(100);
  cout << solve(N, x, list)  << endl;
  }

  {
  int N = 3;
  int x = 10;
  vector<long long> list;
  list.push_back(100);
  list.push_back(1);
  list.push_back(100);
  cout << solve(N, x, list)  << endl;
  }

  {
  int N = 4;
  int x = 10;
  vector<long long> list;
  list.push_back(1);
  list.push_back(2);
  list.push_back(3);
  list.push_back(4);
  cout << solve(N, x, list)  << endl;
  }

  {
    int N = 2;
    long long  x = 1000000000;
    vector<long long> list;
    for (int i = 0; i < N; i++ ) {
      list.push_back(i + 1);
    }
    cout << solve(N, x, list)  << endl;
  }
  // */
  return 0;
}
