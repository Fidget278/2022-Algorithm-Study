# 링크: https://www.acmicpc.net/problem/25304
# 메모리: 30840KB, 시간: 72ms, 코드 길이: 204B 

import sys
ssr = sys.stdin.readline

x, n = [int(ssr()) for _ in range(2)]
ret = 0
for _ in range(n):
  a,b = list(map(int, ssr().split(' ')))
  ret += (a*b)

if x == ret:
  print('Yes')
else: print('No')
