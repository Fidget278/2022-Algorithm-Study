# 링크 : https://www.acmicpc.net/problem/1927
# 시간 : 124ms, 메모리 : 36972KB

import sys
import heapq
ssr = sys.stdin.readline

n = int(ssr())
h = []
for _ in range(n):
  a = int(ssr())
  if a == 0:
    out = heapq.heappop(h) if len(h) != 0 else 0
    print(out)
  else:
    heapq.heappush(h, a)
