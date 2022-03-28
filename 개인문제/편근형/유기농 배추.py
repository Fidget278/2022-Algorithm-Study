# 링크 : https://www.acmicpc.net/problem/1012
# 시간 : 88ms
# 코드 길이 : 734B

import sys
ssr = sys.stdin.readline

t = int(ssr())
direction = [(0,1),(1,0),(0,-1),(-1,0)]
for _ in range(t):
  m,n,k = list(map(int, ssr().split(' ')))
  cnt = 0
  field = [[0 for _ in range(m)] for _ in range(n)]
  stack = []
  for _ in range(k):
    x, y = list(map(int, ssr().split(' ')))
    field[y][x] = 1

  for i in range(n):
    for j in range(m):
      if field[i][j] == 1:
        cnt += 1
        stack.append((i,j))
        field[i][j] = 0
      while stack:
        y,x = stack.pop()
        for dy, dx in direction:
          nx = dx + x
          ny = dy + y
          if 0 <= nx < m and 0 <= ny < n:
            if field[ny][nx] == 1:
              field[ny][nx] = 0
              stack.append((ny,nx))
  print(cnt)
