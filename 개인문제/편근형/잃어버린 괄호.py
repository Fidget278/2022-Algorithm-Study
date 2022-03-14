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
# 다음 식에서 가장 최솟값이 될 수 있게 하는 식은 더할 수 있는 것들은 다 더해서 빼는 것이다.
# 그러므로 '-'를 기준으로 해서 슬라이싱하여 더하고 그 다음 빼준다.
