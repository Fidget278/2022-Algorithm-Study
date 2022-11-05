# 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12987

def solution(A, B):
    if min(A) > max(B):
        return 0
    A.sort(reverse = True)
    B.sort(reverse = True)
    answer = 0
    for a in A:
        if a >= B[0]:
            continue
        else:
            answer += 1
            del B[0]
    return answer
