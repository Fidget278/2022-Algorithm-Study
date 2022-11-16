# 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/64064

import re
from itertools import permutations
def solution(user_id, banned_id):
    answer = []
    banned_id = [i.replace('*', '.') for i in banned_id]
    n = len(banned_id)
    lst = list(permutations(user_id, n))
    for i in lst:
        temp = list(i)
        flag = True
        for j in range(n):
            if (re.match(banned_id[j], temp[j]) and len(temp[j]) == len(banned_id[j])):
                continue
            else:
                flag = False
                break
        if flag and sorted(temp) not in answer:
            answer.append(sorted(temp))
    return len(answer)
