# 링크 : https://www.acmicpc.net/problem/11727
# 시간 : 36ms, 공간 : 30748KB

import sys
ssr = sys.stdin.readline

n = int(ssr())
def solution(n):
  if n == 1:
    return 1
  elif n == 2:
    return 3
  else:
    lst = [0]*(n+1)
    lst[1], lst[2] = 1,3
    for i in range(3, n+1):
      lst[i] = lst[i-1] + (2*lst[i-2])
    return lst[n] % 10007
print(solution(n))
