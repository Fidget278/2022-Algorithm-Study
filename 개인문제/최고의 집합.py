# 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12938

def solution(n, s):
    if s < n :
        return [-1]
    div = s // n
    rem = s % n
    lst = [div for _ in range(n)]
    for idx in range(len(lst)-1, -1, -1):
        if rem <= 0 : break
        lst[idx] += 1
        rem -= 1
    return lst
