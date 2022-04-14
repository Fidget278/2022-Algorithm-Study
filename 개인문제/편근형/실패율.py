# 링크 : https://programmers.co.kr/learn/courses/30/lessons/42889

def solution(N, stages):
    people = len(stages)
    lst = [[i,0] for i, _ in enumerate(range(N), start = 1)]
    for i in range(1, N+1):
        temp = stages.count(i)
        lst[i-1][1] = temp / people
        people -= temp
        if people == 0:
            break
    lst = sorted(lst, key = lambda x : (-x[1], x[0]))
    answer = [i[0] for i in lst]
    return answer
