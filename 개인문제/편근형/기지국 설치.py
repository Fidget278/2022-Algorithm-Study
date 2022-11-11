# 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12979

import math
def solution(n, stations, w):
    answer = 0
    start, end = 1, 1
    for station in stations:
        right = station+w if station + w < n else n
        left = station-w if station - w > 0 else 1
        end = left
        answer += math.ceil((end - start) / (2*w+1))
        start = right + 1
    if start <= n:
        answer += math.ceil((n + 1 - start) / (2*w+1))
    return answer
