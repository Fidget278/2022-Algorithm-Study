# 성공 코드
# 링크 : https://www.acmicpc.net/problem/7662
# 시간 : 7212ms, 공간 : 291224KB
import sys
import heapq as h
ssr = sys.stdin.readline

t = int(ssr())
for _ in range(t):
  k = int(ssr())
  lst1 = []
  lst2 = []
  visited = [False] * k
  for i in range(k):
    command, number = ssr().rstrip().split(' ')
    number = int(number)
    if command == "I":
      h.heappush(lst1, (number, i))
      h.heappush(lst2, (-number,i))
      visited[i] = True
    elif number == 1:
      while lst2 and not visited[lst2[0][1]]:
        h.heappop(lst2)
      if lst2:
        num, idx = h.heappop(lst2)
        visited[idx] = False
    else:
      while lst1 and not visited[lst1[0][1]]:
        h.heappop(lst1)
      if lst1:
        num, idx = h.heappop(lst1)
        visited[idx] = False
  while lst1 and not visited[lst1[0][1]]:
    h.heappop(lst1)
  while lst2 and not visited[lst2[0][1]]:
    h.heappop(lst2)
  print(-lst2[0][0], lst1[0][0]) if lst1 and lst2 else print("EMPTY")


# 실패 코드 (시간 초과)
import sys
import heapq as h
ssr = sys.stdin.readline

t = int(ssr())
for _ in range(t):
  k = int(ssr())
  min_lst = []
  max_lst = []
  for _ in range(k):
    command, number = ssr().rstrip().split(' ')
    number = int(number)
    if command == 'I':
      h.heappush(min_lst, number)
      h.heappush(max_lst, -number)
    elif number == 1:
      if max_lst:
        num = -h.heappop(max_lst)
        min_lst.remove(num)
    else:
      if min_lst:
        num = h.heappop(min_lst)
        max_lst.remove(-num)
  print(-h.heappop(max_lst), h.heappop(min_lst)) if min_lst and max_lst else print('EMPTY')
