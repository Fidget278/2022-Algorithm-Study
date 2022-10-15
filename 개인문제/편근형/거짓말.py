# 링크 : https://www.acmicpc.net/problem/1043
# 시간 : 88ms, 메모리 : 32468KB

import sys
from collections import deque
ssr = sys.stdin.readline

n,m = map(int, ssr().split())
p = set([])
truth = list(map(int, ssr().split()))

if truth[0] == 0:
  print(m)
  exit(0)
q = deque([])

for i in range(1, len(truth)):
  p.add(truth[i])
  q.append(truth[i])

parties = []
for _ in range(m):
  lst = list(map(int, ssr().split()))
  lst.pop(0)
  parties.append(set(lst))

while q:
  a = q.popleft()
  for party in parties:
    if a in party:
      for i in party:
        if i not in p:
          q.append(i)
          p.add(i)

answer = 0
for i in parties:
  if p - i == p:
    answer += 1
print(answer)
