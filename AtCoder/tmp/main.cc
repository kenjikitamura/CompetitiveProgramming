#define _USE_MATH_DEFINES
#include <algorithm>
#include <cstdio>
#include <functional>
#include <iostream>
#include <cfloat>
#include <climits>
#include <cstdlib>
#include <cstring>
#include <cmath>
#include <map>
#include <queue>
#include <set>
#include <sstream>
#include <stack>
#include <string>
#include <time.h>
#include <vector>
#include <random>
#include <list>
using namespace std;
 
typedef long double ld;
typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> i_i;
typedef pair<ll, int> ll_i;
typedef pair<int, ll> i_ll;
typedef pair<double, int> d_i;
typedef pair<ll, ll> ll_ll;
typedef pair<double, double> d_d;
struct edge { int u, v; ll w; };
 
ll MOD = 1000000007;
ll _MOD = 1000000009;
double EPS = 1e-10;
 
int main() {
  int N; cin >> N;
  string s; cin >> s;
  int M = s.length();
  vector<int> dp(N + 1);
  dp[0] = 1;
  for (int t = 0; t < N; t++) {
    vector<int> _dp(N + 1);
    for (int x = 0; x <= t; x++) {
      _dp[x + 1] = (_dp[x + 1] + dp[x]) % MOD;
      if (x) _dp[x - 1] = (_dp[x - 1] + dp[x] * 2LL) % MOD;
      else _dp[x] = (_dp[x] + dp[x]) % MOD;
    }
    dp = _dp;
  }
  cout << dp[M] << endl;
}
