#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <algorithm>
#include <vector>
#include <utility>
#include <iostream>

using namespace std;

void getPrimes(long long N, vector<int>& primes) {
    int n = sqrt(N);
    vector<bool> f(n + 1, true);
    f[0] = false;
    f[1] = false;
    for(int i = 2;i <= n;++i) {
        if(f[i] == true) {
            primes.push_back(i);
            for(int j = i + i;j <= n;j += i) {
                f[j] = false;
            }
        }
    }
}

int primlize(long long N, const vector<int>& primes, vector<pair<int, int> >& Nprime) {
    int s = 1;
    for(size_t i = 0;i < primes.size();++i) {
        int cnt = 0;
        while(N != 0 && N % primes[i] == 0) {
            cnt++;
            N /= primes[i];
        }
        s *= cnt + 1;
        Nprime.push_back(make_pair(primes[i], cnt));
    }
    if(N != 1) {
        s *= 2;
        Nprime.push_back(make_pair(N, 1));
    }
    return s;
}

int main() {
    long long N, M;
    scanf("%lld %lld", &N, &M);
    if(M > N) {
        long long t = M;
        M = N;
        N = t;
    }
    vector<int> primes;
    getPrimes(N, primes);
    
    vector<pair<int, int> > Nprime;
    vector<pair<int, int> > Mprime;
    int s1 = primlize(N, primes, Nprime);
    int s2 = primlize(M, primes, Mprime);
    int ss = s1 * s2;
   
    int i = 0, j = 0;
    int s = 1;
    while(i < Nprime.size() && j < Mprime.size()) {
        if(Nprime[i].first == Mprime[j].first) {
            s *= min(Nprime[i].second, Mprime[j].second) + 1;
            i++;
            j++;
        } else if(Nprime[i].first > Mprime[j].first) {
            j++;
        } else {
            i++;
        }
    }
    
    for(int i = 0;i < primes.size();++i) {
        while(ss % primes[i] == 0 && s % primes[i] == 0) {
            ss /= primes[i];
            s /= primes[i];
        }
    }
    printf("%d %d\n", ss, s);
    return 0;
}