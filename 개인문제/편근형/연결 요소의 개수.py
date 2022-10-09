# 링크 : https://www.acmicpc.net/problem/11724
# 시간 : 1028ms, 메모리 : 70484KB

import sys
from collections import defaultdict, deque

ssr = sys.stdin.readline

n, m = list(map(int, ssr().split(' ')))
visited = [False] * (n+1)
dic = defaultdict(list)
for _ in range(m):
    u, v = list(map(int, ssr().split(' ')))
    dic[u].append(v)
    dic[v].append(u)

answer = 0
for i in range(1,n+1):
  if visited[i] == False:
    answer += 1
    q = deque(dic[i])
    while q:
      a = q.popleft()
      if visited[a] == False:
        visited[a] = True
        q.extend(dic[a])

print(answer)

# bfs를 이용하여 풀이, dfs 활용시 런타임 에러
