# https://school.programmers.co.kr/learn/courses/30/lessons/64065

def solution(s):
    answer = []
    ret = set()
    lst = s[2:-2].split('},{')
    lst = list(sorted(lst, key = lambda x : len(x)))
    for i in lst:
        diff = set((list(map(int, i.split(',')))))
        answer = answer + list(diff.difference(ret))
        ret = set(answer)
    return answer
