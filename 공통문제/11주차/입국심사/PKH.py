def solution(n, times):
    answer = 0
    left = 1; right = max(times) * n
    print(right)
    while left <= right:
        mid = (left + right) // 2
        cnt = 0
        for i in times:
            cnt += mid // i
            if cnt >= n:
                break
        if cnt >= n:
            answer = mid
            right = mid - 1
        elif cnt < n:
            left = mid + 1
    return answer
