# 시간 : 68ms
# 코드 길이 : 262B
# 링크 : https://www.acmicpc.net/problem/1676

import sys
ssr = sys.stdin.readline

# Tabulation
def factorial(n):
  lst = [1,1] + [1]*(n-1)
  for i in range(2, n+1):
    lst[i] = lst[i-1] * i
  return lst[n]

N = int(ssr())
s = len(str(factorial(N)))
temp = len(str(factorial(N)).rstrip('0'))
print(s - temp)
