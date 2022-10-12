# 링크 : https://www.acmicpc.net/problem/11723
# 시간 : 5544ms, 메모리 : 30840KB

import sys

ssr = sys.stdin.readline

m = int(ssr())
s = set()
for _ in range(m):
  cal = ssr().strip().split()
  if len(cal) == 1:
    if cal[0] == 'all':
      s = set([i for i in range(1,21)])
    else:
      s = set()
  else:
    op = cal[0]
    num = int(cal[1])

    if op == 'add':
      s.add(num)
    elif op == 'remove':
      s.discard(num)
    elif op == 'check':
      print(1 if num in s else 0)
    elif op == 'toggle':
      if num in s:
        s.discard(num)
      else:
        s.add(num)
