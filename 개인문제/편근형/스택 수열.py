# 링크 : https://www.acmicpc.net/problem/1874
# 시간 : 196ms
# 코드 길이 : 406B

import sys
ssr = sys.stdin.readline

n = int(ssr())
stack = list(reversed([int(ssr()) for _ in range(n)]))
temp = []
answer = []
flag = True
cur = 1

while stack:
  a = stack.pop()
  while cur <= a:
    answer.append("+")
    temp.append(cur)
    cur += 1
  if(a == temp[-1]):
    temp.pop()
    answer.append("-")
  else:
    flag = False
    break

if flag:
  print(*answer, sep='\n')
else:
  print("NO")
