# 링크 : https://www.acmicpc.net/problem/1764
# 시간 : 128ms

import sys
ssr = sys.stdin.readline

n, m = map(int, ssr().split(' '))
listen = set([str(ssr().rstrip()) for _ in range(n)])
see = set([str(ssr().rstrip()) for _ in range(m)])
ret = list(listen.intersection(see))
ret.sort()
print(len(ret), *ret, sep='\n')
