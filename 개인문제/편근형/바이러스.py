# 링크 : https://www.acmicpc.net/problem/2606
# 시간 : 88ms, 메모리 : 32432KB

import sys
from collections import defaultdict, deque
ssr = sys.stdin.readline

n = int(ssr())
m = int(ssr())
d = defaultdict(list)
visited = [False] * (n+1)
for _ in range(m):
  a,b = list(map(int, ssr().split(' ')))
  d[a].append(b)
  d[b].append(a)

q = deque([d[1]])
visited[1] = True
while q:
  nodes = q.popleft()
  for i in nodes:
    if not visited[i]:
      q.append(d[i])
      visited[i] = True

print(visited.count(True) - 1)

# bfs를 활용해 풀이
