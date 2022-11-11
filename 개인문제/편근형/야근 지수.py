# 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12927

import heapq as h
def solution(n, works):
    if sum(works) <= n:
        return 0
    lst = []
    for i in works:
        h.heappush(lst, -i)
    for _ in range(n):
        a = h.heappop(lst) + 1
        h.heappush(lst, a)
    return sum([i ** 2 for i in lst])
