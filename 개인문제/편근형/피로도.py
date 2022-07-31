# 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/87946

from itertools import permutations
def solution(k, dungeons):
    answer = 0
    lst = list(permutations(dungeons))
    for i in lst:
        temp = k
        cnt = 0
        for j in i:
            if j[0] > temp:
                break
            temp -= j[1]
            cnt += 1
        answer = max(answer, cnt)
    return answer
