# 링크 : https://www.acmicpc.net/problem/1260
# 시간 : 304ms
# 메모리 : 32452KB
# 코드 길이 : 692B

import sys
from collections import defaultdict, deque
ssr = sys.stdin.readline

n, m, v = map(int, ssr().split(' '))
graph = defaultdict(list)
for _ in range(m):
  i, j = map(int, ssr().split(' '))
  graph[i].append(j)
  graph[j].append(i)
  graph[i].sort()
  graph[j].sort()

def dfs(point, visited = []):
  visited.append(point)
  for a in graph[point]:
    if a not in visited:
      visited = dfs(a, visited)
  return visited

def bfs(point):
  visited = [point]
  q = deque([point])
  while q:
    temp = q.popleft()
    for a in graph[temp]:
      if a not in visited:
        visited.append(a)
        q.append(a)
  return visited
  
print(*dfs(v), sep = ' ')
print(*bfs(v), sep = ' ')
