# 링크 : https://programmers.co.kr/learn/courses/30/lessons/60057

from collections import deque

def solution(s):
    l = len(s) // 2
    answer = len(s)
    for i in range(1, l+1):
        ret = ''
        lst = deque([s[i*j: (j+1) * i] for j in range((len(s) + i - 1)//i)]) # 일정 길이로 문자열 슬라이싱
        rep = lst.popleft()
        cnt = 1
        while True:
            # 슬라이싱된 문자열의 리스트가 다 pop 되었을 경우 반복 종료
            if len(lst) == 0:
                if cnt != 1:
                    ret += str(cnt) + rep
                else:
                    ret += rep
                break
                
            temp = lst.popleft()
            # 같을 경우
            if temp == rep:
                cnt += 1 # 중복 횟수 추가
            # 다를 경우
            else:
                if cnt != 1: # 중복 횟수가 1이 아닌 경우는 숫자를 문자열에 추가, 중복 횟수 1로 초기화
                    ret += str(cnt) + rep
                    cnt = 1
                else:
                    ret += rep # 중복 횟수가 1인 경우 문자열만 추가
                rep = temp # 중복 문자열의 재선정
        # 해당 재정립된 문자열이 기존 최소 문자열보다 길이가 
        if len(ret) < answer:
            answer = len(ret)
    return answer
