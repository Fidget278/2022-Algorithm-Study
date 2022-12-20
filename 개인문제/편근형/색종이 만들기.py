# 링크 : https://www.acmicpc.net/problem/2630
# 시간 : 52ms, 공간 : 30616KB

import sys
ssr = sys.stdin.readline

N = int(ssr())
board = [list(map(int, ssr().rstrip().split(' '))) for _ in range(N)]
result = [0,0]

def solution(x, y, n):
  color = board[x][y]
  for i in range(x, x + n):
    for j in range(y, y + n):
      if color != board[i][j]:
        div = n // 2
        solution(x, y + div, div)
        solution(x + div, y + div, div)
        solution(x + div, y, div)
        solution(x, y, div)
        return
  
  if color == 0:
    result[0] += 1
  else:
    result[1] += 1

solution(0,0,N)
print(result[0], result[1], sep='\n')
