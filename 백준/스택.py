# 시간 : 80ms
# 코드 길이 : 446B
# 링크 : https://www.acmicpc.net/problem/10828

import sys
ssr = sys.stdin.readline

n = int(ssr())
lst = []

for _ in range(n):
  s = str(ssr())
  if(s.startswith("push")):
    lst.append(s.split(' ')[1].rstrip())

  elif (s.rstrip() == "pop"):
    print(-1 if len(lst) == 0 else lst.pop())

  elif(s.rstrip() == "size"):
    print(len(lst))

  elif(s.rstrip() == "empty"):
    print(1 if len(lst) == 0  else 0)

  elif(s.rstrip() == "top"):
    print(-1 if len(lst) == 0 else lst[len(lst)-1])
