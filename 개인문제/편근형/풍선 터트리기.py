# 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/68646
def solution(a):
    ret = [False]*len(a)
    left, right = float('inf'), float('inf') 
    for i in range(len(a)):
        if a[i] < left:
            left = a[i]
            ret[i] = True
        if a[-1-i] < right:
            right = a[-1-i]
            ret[-1-i] = True
    return sum(ret)
