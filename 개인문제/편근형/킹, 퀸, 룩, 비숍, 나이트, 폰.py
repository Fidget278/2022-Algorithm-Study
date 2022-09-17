# 링크: https://www.acmicpc.net/problem/3003
# 메모리: 30840KB, 시간: 68ms, 코드 길이: 157B

import sys
ssr = sys.stdin.readline

lst = list(map(int, ssr().split(' ')))
comp = [1,1,2,2,2,8]
ret = [i-j for i, j in zip(comp, lst)]

print(*ret, sep=' ')
