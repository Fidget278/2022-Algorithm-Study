# 링크 : https://www.acmicpc.net/problem/1074

# 실패
# 원인 : 메모리 초과
import sys
ssr = sys.stdin.readline

def find_point(n, point, mov):
  if n == -1:
    print(mov)
  else:
    temp = 2**n
    if (point[0] < temp) and (point[1] < temp):
      mov += 0
    elif (point[0] < temp) and (point[1] >= temp):
      mov += temp**2
      point = (point[0], point[1] - temp)
    elif (point[0] >= temp) and (point[1] < temp):
      mov += (temp**2)*2
      point = (point[0] - temp, point[1])
    else:
      mov += (temp**2)*3
      point = (point[0] - temp, point[1] - temp)
    find_point(n-1, point, mov)

n,r,c = list(map(int, ssr().split(' ')))
lst = [[(r,c) for c in range(2**n)] for r in range(2**n)]
target = lst[r][c]
mov = 0
find_point(n-1, target, mov)
