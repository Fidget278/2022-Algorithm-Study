# 링크 : https://www.acmicpc.net/problem/1966
# 시간 : 100ms
# 코드 길이 : 555B

# 순환 큐를 위해서 deque을 사용
import sys
from collections import deque
ssr = sys.stdin.readline

case = int(ssr())

# 각 케이스마다 출력.
for _ in range(case):
  n, m = list(map(int, ssr().split(' ')))
  priority = deque(map(int, ssr().split(' ')))
  # 우선순위와 인덱스를 위해서 enumerate 함수 이용하여 튜플로 덱 작성
  priority = deque([(i, j) for i, j in enumerate(priority)]) 
  # 우선순위의 최댓값
  Max = max(priority, key=lambda x:x[1])[1]
  # 출력한 문서의 순서
  cnt = 1
  
  while True:
    idx, pri = priority.popleft()
    # 우선순위와 인덱스가 일치할 경우가 정답. 그러므로 반복문 탈출
    if idx == m and pri == Max:
      break
    # 우선순위가 높은 것을 출력하므로 cnt에 1을 증가. 우선순위의 최댓값을 다시 구한다.
    elif idx != m and pri == Max:
      cnt += 1
      Max = max(priority, key=lambda x:x[1])[1]
    # 이도저도 아닌 경우는 다시 덱의 맨 뒤로 보낸다.
    else:
      priority.append((idx,pri))
  print(cnt)
