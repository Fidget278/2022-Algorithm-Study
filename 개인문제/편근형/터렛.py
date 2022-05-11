# 링크 : https://www.acmicpc.net/problem/1002
# 시간 : 80ms
# 메모리 : 30888KB
# 코드 길이 : 476B

import math
T = int(input())
nums = [[int(x) for x in input().split()] for _ in range(T)]
result = []

for i in nums:
  x1, y1, r1, x2, y2, r2 = i

  d = math.sqrt(((x1 - x2) ** 2) + ((y1 - y2) ** 2))
  a = abs(r1 + r2)
  b = abs(r1-r2)

  if b < d < a:
    result.append(2)
  elif d != 0 and (b == d or a == d):
    result.append(1)
  elif a < d or b > d or (d == 0 and b != 0):
    result.append(0)
  elif d == 0 and b == 0:
    result.append(-1)
for i in result:
  print(i)
