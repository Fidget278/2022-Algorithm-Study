# 링크 : https://www.acmicpc.net/problem/1654
# 시간 : 100ms
# 코드 길이 : 383B

import sys
ssr = sys.stdin.readline

k, n = list(map(int, ssr().split()))
l = [int(ssr()) for _ in range(k)]

l.sort(reverse = True)
Max = l[0]
start, end = 1, Max
middle, answer = 0, 0

while start <= end:
  middle = (start + end) // 2
  ret = sum([i//middle for i in l])
  if(ret >= n):
    answer = middle
    start = middle + 1
  elif(ret < n):
    end = middle - 1
print(answer)

# 이진탐색을 이용하여 문제를 해결한다.
