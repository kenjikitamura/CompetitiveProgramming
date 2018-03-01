#include <stdio.h>
#include <algorithm>
#include <string.h>
#include <iostream>
#include <vector>
#include <map>
using namespace std;

map<int, map<int, bool> > m;
int N, M;

bool canTalk(int p1, int p2) {
  for (int p1lang = 1; p1lang < M; p1lang++) {
    if (m[p1][p1lang] && m[p2][p1lang]) {
      return true;
    }
  }
  cout << "p1=" << p1 << " p2=" << p2 << " not talk direct" << endl;
  for (int p3 = 0; p3 < N; p3++) {
    if (p3 == p1 || p3 == p2) {
      continue;
    }
    cout << "check p3=" << p3 << endl;
    for (int p1lang = 1; p1lang < M; p1lang++) {
      if (m[p1][p1lang] && m[p3][p1lang]) {
        cout << "check p3 p1 can talk" << endl;
        for (int p2lang = 1; p2lang < M; p2lang++) {
          if (m[p2][p2lang] && m[p3][p2lang]) {
            cout << "check p3 p2 can talk OK!" << endl;
            return true;
          }
        }
      }
    }
  }
  return false;
}

int main() {
  cin >> N >> M;

  // read
  for (int i = 0; i < N; i++) {
    int K; cin >> K;
    for (int j = 0; j < K; j++) {
      int lang; cin >> lang;
      m[i][lang] = true;
    }
  }

  // check
  for (int p1 = 0; p1 < N; p1++) {
    for (int p2 = p1 + 1; p2 < N; p2++) {
      if (canTalk(p1, p2)) {
        // 
      } else {
        cout << "NO";
        return 0;
      }
    }
  }

  cout << "YES";
  return 0;
}
