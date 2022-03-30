# 링크 : https://programmers.co.kr/learn/courses/30/lessons/17678

from collections import deque # 덱 사용

def solution(n, t, m, timetable):
    hr = 0; mn = 0
    
    # 크루들의 시간표를 string에서 int형으로 변환시켜 [시, 분] 형태의 리스트로 변환
    timetable = [list(map(int, i.split(":"))) for i in timetable]
    # 시, 분 순서로 정렬
    timetable.sort(key=lambda x : (x[0],x[1]))
    timetable = deque(timetable)
    
    # 셔틀의 시작 시간
    hour, minute = 9, 0
    shuttle = deque([[hour, minute]])
    # 셔틀 시간표 만들기
    for i in range(n-1):
        minute += t
        if minute >= 60:
            temp = minute // 60
            hour += temp
            minute -= (temp * 60)
        shuttle.append([hour, minute])
    
    # 해당 셔틀에 탈 수 있는 크루들을 stack에 저장.
    while shuttle:
        stack = []
        a,b = shuttle.popleft()
        while True:
            if len(timetable) == 0:
                break
            x, y = timetable.popleft()
            if ((a > x) or (a == x and b >= y)) and (len(stack) < m):
                stack.append([x,y])
            else: 
                timetable.appendleft([x,y])
                break
                
        # 최대한 늦게 타는 것을 구하는 것이기 때문에 마지막 셔틀에 타는 크루들만 검색하면 된다.
        if len(shuttle) == 0:
            # 해당 셔틀에 탄 탑승인원이 정원보다 작은 경우에는 해당 셔틀에 맞춰서 가면 된다.
            if len(stack) < m:
                hr, mn = a,b
            # 해당 셔틀에 탄 탑승인원이 정원일 경우 맨 마지막 크루보다 1분 전에만 오면 된다.
            else:
                temp_h, temp_m = stack.pop()
                temp_m -= 1
                if temp_m < 0:
                    temp_m += 60
                    temp_h -= 1
                hr, mn = temp_h, temp_m
    
    # 구한 시간을 'HH:mm' 형태로 변환.
    hr, mn = str(hr), str(mn)
    if len(hr) == 1:
        hr = '0' + hr
    if len(mn) == 1:
        mn = '0' + mn
    ret = hr + ':' + mn
    return ret
