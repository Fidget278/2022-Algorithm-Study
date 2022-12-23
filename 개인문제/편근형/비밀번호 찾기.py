# 링크 : https://www.acmicpc.net/problem/17219
# 시간 : 228ms, 공간 : 48396KB

import sys
ssr = sys.stdin.readline

n, m = map(int, ssr().rstrip().split(' '))
d = dict()
for _ in range(n):
  location, password = ssr().rstrip().split(' ')
  d[location] = password

for i in range(m):
  problem = ssr().rstrip()
  print(d[problem])
