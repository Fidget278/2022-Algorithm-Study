# 링크 : https://www.acmicpc.net/problem/15829
# 시간 : 84ms
# 코드 길이 : 350B
# 모듈러 연산에 대한 공식을 이용하여 풀면 100점이 나온다.
# 예시로 든 식을 이용하여 풀면 50점만 나온다.

import sys
ssr = sys.stdin.readline

n = int(ssr())
s = list(str(ssr().rstrip()))
r, m = 31, 1234567891
cnt = 0
temp = 0

a_mod = dict()
r_mod = []

for i in range(97, 123):
  a_mod[chr(i)] = (i-96) % m

for i in range(0, 51):
  r_mod.append((r ** i) % m)

for i in s:
  temp += (a_mod[i] * r_mod[cnt]) % m
  cnt += 1

answer = temp % m
print(answer)
