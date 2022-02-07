# 시간 : 104ms
# 메모리 : 444B
# 복잡도 : O(n^2)
# 링크 : https://www.acmicpc.net/problem/9375

from functools import reduce
from collections import defaultdict
import sys
ssr = sys.stdin.readline

# 배열의 요소를 곱하기 위한 함수
def multiply(lst):
  return reduce(lambda x, y : x * y, lst)

T = int(ssr()) # 테스트 케이스
for _ in range(T):
  I = int(ssr()) # 의상의 수
  
  # 의상의 수가 0개일 때
  if I == 0:
    print(0)

  # 의상의 수가 1개 이상일 때
  else:
    d = defaultdict(list)
    for _ in range(I):
      a, b = list(map(str,ssr().split()))
      d[b].append(a)
    
    # 해당 종류의 의상을 고르지 않았을 경우를 생각해 1을 더한다.
    cnt = [len(i[1]) + 1 for i in d.items()]
    # 모든 종류의 의상을 고르지 않을 경우를 제외해야 하므로 1을 뺀다.
    print(multiply(cnt) - 1)
