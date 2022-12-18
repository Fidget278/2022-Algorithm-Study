# 링크 : https://www.acmicpc.net/problem/11279
# 시간 : 124ms, 공간 : 36992KB

import sys
import heapq
ssr = sys.stdin.readline

n = int(ssr())
h = []
for _ in range(n):
  a = int(ssr())
  if a == 0:
    out = heapq.heappop(h) if len(h) != 0 else 0
    print(-out)
  else:
    heapq.heappush(h, -a)
