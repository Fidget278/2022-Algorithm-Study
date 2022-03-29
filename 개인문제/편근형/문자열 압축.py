# 링크 : https://programmers.co.kr/learn/courses/30/lessons/60057

from collections import deque

def solution(s):
    l = len(s) // 2
    answer = len(s)
    for i in range(1, l+1):
        ret = ''
        lst = deque([s[i*j: (j+1) * i] for j in range((len(s) + i - 1)//i)])
        rep = lst.popleft()
        cnt = 1
        while True:
            if len(lst) == 0:
                if cnt != 1:
                    ret += str(cnt) + rep
                else:
                    ret += rep
                break
                
            temp = lst.popleft()
            if temp == rep:
                cnt += 1
            else:
                if cnt != 1:
                    ret += str(cnt) + rep
                    cnt = 1
                    rep = temp
                else:
                    ret += rep
                    rep = temp
        if len(ret) < answer:
            answer = len(ret)
    return answer
