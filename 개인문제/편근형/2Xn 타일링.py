# 링크 : https://www.acmicpc.net/problem/11726
# 시간 : 40ms, 메모리 : 30616KB

import sys
ssr = sys.stdin.readline()

n = int(ssr)
if n == 1:
  print(1)
elif n == 2:
  print(2)
else:
  lst = [i for i in range(n+1)]
  lst[1] = 1
  lst[2] = 2
  for i in range(3, n+1):
    lst[i] = lst[i-1] + lst[i-2]
  print(lst[i] % 10007)

# 이것은 memoization과 함께 피보나치 수열을 이용해 해결한다.
