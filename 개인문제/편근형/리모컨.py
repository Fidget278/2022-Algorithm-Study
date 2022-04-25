# 링크 : https://www.acmicpc.net/problem/1107
# 시간 : 1060ms
# 메모리 : 70832KB
# 코드 길이 : 443B

import sys
ssr = sys.stdin.readline

n = int(ssr())
m = int(ssr())
brokens = set(ssr().rstrip().split(' ')) if m != 0 else set()
lst = [i for i in range(0, int(1e6) + 1)]
answer = abs(n-100)

if n == 100:
  answer = 0
elif m == 10:
  pass
elif m == 0:
  answer = min(answer, len(str(n)))
else:
  for i in lst:
    for j in str(i):
      if j in brokens:
        break
    else:
      answer = min(answer, len(str(i)) + abs(n-i))

print(answer)
