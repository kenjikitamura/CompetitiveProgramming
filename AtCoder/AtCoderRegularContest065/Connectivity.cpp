#include <stdio.h>
#include <algorithm>
#include <map>
#include <string.h>
#include <iostream>
#include <vector>
using namespace std;

struct UF {
    vector<int> data;
    UF(int n) {
        data.resize(n, -1);
    }
    int root(int i) {
        return data[i] < 0 ? i : data[i] = root(data[i]);
    }
    int size(int i) {
        i = root(i);
        return -data[i];
    }
    void unite(int x, int y) {
        x = root(x), y = root(y);
        if (x == y) return;
        if (data[x] > data[y]) swap(x, y);
        data[x] += data[y];
        data[y] = x;
    }
    bool same(int x, int y) {
        return root(x) == root(y);
    }
};


int N,K,L;
int tree[200000];
int rnk[200000];

int main() {
  cin >> N >> K >> L;
  int p[K], q[K], r[L], s[L];
  UF a(N), b(N);
  for (int i = 0; i < K; i++){
    int p, q;
    cin >> p >> q;
    p--;q--;
    a.unite(p, q);
  }
  for (int i = 0; i < L; i++){
    int p, q;
    cin >> p >> q;
    p--;q--;
    b.unite(p, q);
  }

  map<pair <int, int>, int> m;
  for ( int i = 0; i < N; i++) {
    pair<int, int> p(a.root(i), b.root(i));
    m[p]+= 1;
  }

  for (int i = 0; i < N; i++) {
    if (i != 0) cout << ' ';
    pair<int, int> p(a.root(i), b.root(i));
    cout << m[p];
  }
}
