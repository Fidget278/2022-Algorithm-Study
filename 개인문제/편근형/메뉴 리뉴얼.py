# https://school.programmers.co.kr/learn/courses/30/lessons/72411

from collections import Counter
from itertools import combinations

def solution(orders, course):
    answer = []
    for i in course:
        lst = []
        for j in orders:
            lst += list(combinations(sorted(j), i))
        M = Counter(lst).most_common()
        answer += [''.join(a) for a,b in M if b > 1 and b == M[0][1]]
    answer.sort()
    return answer
