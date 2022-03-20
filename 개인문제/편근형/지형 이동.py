# https://programmers.co.kr/learn/courses/30/lessons/62050

import heapq as h

def solution(land, height):
    n = len(land) # 길이
    move = [(-1,0),(1,0),(0,-1),(0,1)] # 좌표 이동
    visited = [[False for _ in range(n)] for _ in range(n)] # 방문 여부
    q = [(0,0,0)] # 사다리 비용, x좌표, y좌표. 비용이 0인 것은 사다리 미설치
    pay = 0; # 높이
    now = 0; # 현재 몇번째 타일?
    
    # 마지막 타일까지
    while now < n * n:
        value, x, y = h.heappop(q) # heapq의 heappop은 최솟값을 먼저 빼는 방식이다.
        
        # 만약 방문한 경우 스킵
        if visited[x][y] == True:
            continue
        
        # 방문 안 했을 경우 체크
        visited[x][y] = True
        
        pay += value # 사다리 비용
        now += 1 # 타일
        
        # 현재 타일에서 상,하,좌,우의 타일을 조회하여 각 타일의 비용 확인
        for dx, dy in move:
            nx = dx + x; ny = dy + y 
            
            # 존재하지 않는 타일인 경우 스킵
            if nx < 0 or ny < 0 or nx > n-1 or ny > n-1:
                continue
            
            diff = abs(land[nx][ny] - land[x][y]) # 현재 타일로부터의 사다리 비용
            
            # 한계 높이보다 높을 경우
            if diff > height:
                h.heappush(q, (diff, nx, ny)) # 사다리가 필요하므로 사다리 비용과 함께 좌표 저장
            
            # 아닌 경우
            else:
                h.heappush(q, (0, nx, ny)) # 사다리가 필요없으므로 비용은 0으로 하여 좌표 저장
    return pay # 비용을 계속 더하고 있었고 최솟값을 먼저 빼서 더하고 이미 방문한 경우의 좌표는 스킵하였으니 자동적으로 최솟값이 된다.
