# https://www.acmicpc.net/problem/1541
# 시간 : 140ms

import sys
import re

input = sys.stdin.readline
ex = input().rstrip()
lst = re.split('-',ex)
ret = sum(list(map(int, re.split('\+', lst[0]))))
for i in range(1, len(lst)):
  ret -= sum(list(map(int, re.split('\+', lst[i]))))
print(ret)

# 그리디 문제
