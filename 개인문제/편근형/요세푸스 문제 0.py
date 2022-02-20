# 링크 : https://www.acmicpc.net/problem/11866
# 시간 : 100ms
# 링크 : 475B
# 환형 큐 구조 이해

from collections import deque
import sys
ssr = sys.stdin.readline

n, k = list(map(int, ssr().split(' ')))
q = deque([i+1 for i in range(n)])
lst = []

while q:
  if len(q) >= k:
    l = len(q)
    rem = l % k
    cnt = 1
    while k * cnt <= l:
      q.rotate(-(k-1))
      a = q.popleft()
      cnt += 1
      lst.append(a)
  else:
    num = k - len(q)
    q.rotate(-(num-1))
    a = q.popleft()
    lst.append(a)
print("<", end='')
print(*lst, sep=", ", end='')
print(">")
