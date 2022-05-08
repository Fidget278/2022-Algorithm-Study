'''
1. 배열에서 숫자를 꺼낼 때는 맨 앞에서 꺼낼수 있고, 넣을 때는 맨 뒤로 넣는다. 
2. 숫자를 꺼내고 넣는 행위를 1회 이동이라고 한다.
3. 두 배열내 숫자의 합이 같아지기 위해선 최소한 몇번 이동해야하는가?
4. 아무리해도 합이 같아지지 않는 경우 -1을 출력한다.

# 예제1
[[3,2,7,2], [4,6,5,1]]
각각의 합은 14,16이다.
15,15가 되기 위해서는 앞의 배열에서 3을 빼서 뒤쪽 배열에 넣고, 뒤쪽 배열에서 4를 빼서 앞쪽 배열에 넣으면 각 배열의 합이 15가 된다.
즉, 두개의 배열이 같아지기 위해선 최소 2회 이동을 하면된다. 

#예제2
[[1,2,1,2],[1,10,1,2]]
각각의 합은 6,14이다.
뒤쪽 배열에서 1,10을꺼내 앞쪽 배열에 넣는다. 그러면 [[1,2,1,2,1,10],[1,2]]가 된다.
이후 앞쪽 배열에서 1,2,1,2,1 를 꺼내서 뒤쪽 배열에 넣으면 [[10],[1,2,1,2,1,2,1]]가 되면서 두개의 배열의 합이 10으로 같아진다.
즉, 두개의 배열의 합이 같아지기 위해선 7회 이동을 하면 된다.
'''

from collections import deque
import sys
ssr = sys.stdin.readline

# queue1 = [3,2,7,2]
# queue2 = [4,6,5,1]
# 2

# queue1 = [1,2,1,2]
# queue2 = [1,10,1,2]
# 7

# queue1 = [31,4,3]
# queue2 = [1,2,3]
# -1 

# queue1 = [2]
# queue2 = [2,2,8,2]
# 6

# queue1 = [2]
# queue2 = [2,2,2,2,2,2,16,2]
# 14

# queue1 = [2]
# queue2 = [2,2,7,2]
# -1

queue1 = [10, 2]
queue2 = [5, 7, 2]
# -1

# queue1 = [4,2,3,1]
# queue2 = [2,3]
# -1

# queue1 = [1,2,2]
# queue2 = [1,1]
# -1

# queue1 = [2]
# queue2 = [1,1,1,1,8,2]

q1 = deque(queue1)
q2 = deque(queue2)
q = q1 + q2
S,M,N = sum(q), max(q),len(q)
# print(sum(q))
flag = True
cnt = 0
if (S % 2 != 0) or (S - M < M):
  print(-1)
else:
  ret = sum(q) // 2
  while True:
    if(len(q1) == 0 or len(q2) == 0) or (2*N*(N-2) < cnt):
      flag = False
      break
    a,b = sum(q1), sum(q2)
    if (a > b):
      i = q1.popleft()
      q2.append(i)
      cnt += 1
    elif (a < b):
      i = q2.popleft()
      q1.append(i)
      cnt += 1
    else:
      break
  if flag:
    print(cnt)
  else:
    print(-1)
