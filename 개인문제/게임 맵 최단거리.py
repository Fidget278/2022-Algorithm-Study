# https://school.programmers.co.kr/learn/courses/30/lessons/1844

from collections import deque
def solution(maps):
    answer = 0
    dx = [1,0,-1,0]
    dy = [0,-1,0,1]
    endx, endy = len(maps)-1, len(maps[0])-1
    if endx == 0 and endy == 0:
        return 1
    q = deque()
    q.append((0,0))
    
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if 0 <= nx <= endx and 0 <= ny <= endy and maps[nx][ny] == 1:
                maps[nx][ny] = maps[x][y] + 1
                q.append((nx,ny))
    return maps[endx][endy] if maps[endx][endy] > 1 else -1
