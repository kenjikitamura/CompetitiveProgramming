#include <stdio.h>
#include <algorithm>
#include <string.h>
#include <iostream>
#include <vector>
using namespace std;

int main() {
  int H; cin >> H;
  int W; cin >> W;

  for (int i = 0; i < H; i++) {
    for (int j = 0; j < W; j++) {
      string s;
      cin >> s;
      if (s == "snuke") {
        string ans;
        ans += ('A' + j);
        cout << ans << (i+1) << endl;
      }
    }
  }
  return 0;
}
