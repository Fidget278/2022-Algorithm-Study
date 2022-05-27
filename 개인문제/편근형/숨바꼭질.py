# 링크 : https://www.acmicpc.net/problem/1697
# 시간 : 188ms

from collections import deque
import sys
ssr = sys.stdin.readline

n,k = map(int, ssr().split(' '))
answer = 0

lst = [100001 for i in range(100001)]
lst[n] = 0

q = deque([n])
while True:
  a = q.popleft()
  for i in [a-1, a+1, 2*a]:
    if 0 <= i <= 100000 and lst[i] == 100001:
      lst[i] = lst[a] + 1
      q.append(i)
  if(lst[k] != 100001):
    break
print(lst[k])
