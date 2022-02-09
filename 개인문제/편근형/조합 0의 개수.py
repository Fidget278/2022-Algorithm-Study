# 시간 : 68ms
# 코드 길이 : 329B
# 시간 복잡도 : O(n)
# 링크 : https://www.acmicpc.net/problem/2004
# Python에서 배열은 3억부터 메모리 에러가 나기 시작. 해당 문제는 20억까지 구해야하므로 메모이제이션은 불가


import sys
ssr = sys.stdin.readline

def counting(n):
  n1, n2 = n,n
  cnt_2, cnt_5 = 0, 0
  while n1 != 0:
    n1 //= 2
    cnt_2 += n1
  while n2 != 0:
    n2 //= 5
    cnt_5 += n2
  return cnt_2, cnt_5

a,b = list(map(int, ssr().split()))
c = a-b
u,v = counting(a)
w,x = counting(b)
y,z = counting(c)

print(min(u-w-y, v-x-z))
