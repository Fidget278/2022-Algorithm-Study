# 링크 : https://www.acmicpc.net/problem/9095
# 시간 : 72ms, 메모리 : 30840KB

import sys

ssr = sys.stdin.readline
t = int(ssr())

lst = [0 for _ in range(12)]
lst[1],lst[2],lst[3] = 1,2,4
for i in range(4,12):
  lst[i] = lst[i-1] + lst[i-2] + lst[i-3]

for _ in range(t):
  n = int(ssr())
  print(lst[n])
