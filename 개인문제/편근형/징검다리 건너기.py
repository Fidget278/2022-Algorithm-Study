# https://school.programmers.co.kr/learn/courses/30/lessons/64062
# 이분탐색으로 풀어야 효율성에서  통과
# 슬라이딩 윈도우 같은 경우 효율성에서 통과하지 못함

def solution(stones, k):
    start = 1
    end = 200000000
    while start <= end:
        cnt = 0
        mid = (start + end) // 2
        for s in stones:
            if s - mid <= 0:
                cnt += 1
            else : cnt = 0
            if cnt >= k:
                break
        if cnt >= k:
            end = mid - 1
        else : start = mid + 1
    return start
