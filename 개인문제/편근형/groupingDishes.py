# 링크 : https://app.codesignal.com/interview-practice/question/xrFgR63cw7Nch4vXo/solutions

from collections import defaultdict

def solution(dishes):
    d = defaultdict(list)
    for dish in dishes:
        food = dish[0]
        for i in range(1, len(dish)):
            d[dish[i]].append(food)
    answer = []
    for i in d:
        if len(d[i]) == 1:
            continue
        d[i].sort()
        answer.append([i] + d[i])
    answer.sort()
    return answer
