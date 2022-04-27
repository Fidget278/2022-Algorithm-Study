# 링크 : https://www.acmicpc.net/problem/1389
# 시간 : 100ms
# 메모리 : 30840KB
# 코드 길이 : 509B

# floyd-warshall 알고리즘을 이용할 것.

import sys
ssr = sys.stdin.readline

n, m = map(int, ssr().split(' '))
graph = [[float("inf") for _ in range(n)] for _ in range(n)]
for _ in range(m):
  a,b = map(int, ssr().split(' '))
  graph[a-1][b-1] = 1
  graph[b-1][a-1] = 1
for i in range(len(graph)):
  graph[i][i] = 0

for i in range(n):
  for j in range(n):
    for k in range(n):
      if graph[j][k] > graph[j][i] + graph[i][k]:
        graph[j][k] = graph[j][i] + graph[i][k]

cnt = [sum(i) for i in graph]
ret = cnt.index(min(cnt)) + 1
print(ret)
