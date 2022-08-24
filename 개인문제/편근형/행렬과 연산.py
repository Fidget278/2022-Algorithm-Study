# https://school.programmers.co.kr/learn/courses/30/lessons/118670

# 정확성 만점, 효율성 4개 틀림
from collections import deque
def solution(rc, operations):
    temp = deque([deque(i) for i in rc])
    for i in operations:
        if i == "ShiftRow":
            a = temp.pop()
            temp.appendleft(a)
        else:
            c = 0
            b = temp[0].pop()
            for j in range(0, len(temp)-1):
                if j != len(temp)-2:
                    c = temp[j+1].pop()
                temp[j+1].append(b)
                b = c
                temp[j].appendleft(temp[j+1].popleft())
    return [list(i) for i in temp]
