#include <stdio.h>
#include <algorithm>
#include <string.h>
#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

std::string Replace( std::string String1, std::string String2, std::string String3 )
{
    std::string::size_type  Pos( String1.find( String2 ) );

    while( Pos != std::string::npos )
    {
        String1.replace( Pos, String2.length(), String3 );
        Pos = String1.find( String2, Pos + String3.length() );
    }

    return String1;
}

int main() {
  string S; cin >> S;
  while (true) {
    if (S.size() == 0) {
      cout << "YES" << endl;
      return 0;
    }

    if (S.size() >= 7 && S.substr(S.size() -7, 7) == "dreamer") {
      S = S.substr(0, S.size() -7);
      continue;
    }
    if (S.size() >= 6 && S.substr(S.size() -6, 6) == "eraser") {
      S = S.substr(0, S.size() -6);
      continue;
    }
    if (S.size() >= 5 && S.substr(S.size() -5, 5) == "dream") {
      S = S.substr(0, S.size() -5);
      continue;
    }
    if (S.size() >= 5 && S.substr(S.size() -5, 5) == "erase") {
      S = S.substr(0, S.size() -5);
      continue;
    }
    cout << "NO" << endl;
    return 0;
  }
}
