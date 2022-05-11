# 링크 : https://www.acmicpc.net/problem/1005
# 시간 : 1188ms
# 메모리 : 34684KB
# 코드 길이 : 981B

from collections import defaultdict
import sys
import heapq

input = sys.stdin.readline

def solution(precede_list, build_next, Time,target):
  queue = [(Time[idx],idx) for idx in range(1, len(precede_list)) if precede_list[idx] == 0]
  heapq.heapify(queue)

  while queue:
    finish_time, building = heapq.heappop(queue)
    if building == target:
      return finish_time
    for next_possible in build_next[building]:
      precede_list[next_possible] -= 1
      if precede_list[next_possible] == 0:
        heapq.heappush(queue, (finish_time + Time[next_possible], next_possible))

T = int(input())
for _ in range(T):
  N, K = map(int, input().split())
  start_list = [0 for _ in range(N+1)]
  build_next = defaultdict(list)
  Time = list(map(int,input().split()))
  Time.insert(0,0)
  for _ in range(K):
    start, end = map(int, input().split())
    start_list[end] += 1
    build_next[start].append(end)
  W = int(input())
  print(solution(start_list, build_next, Time, W))
