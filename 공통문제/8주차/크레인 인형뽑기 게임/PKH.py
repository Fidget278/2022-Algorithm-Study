from collections import deque

def solution(board, moves):
    cnt = 0; idx = 1
    lst = deque([])
    moves = deque(moves)
    board = list(map(list, zip(*board)))
    temp = []
    
    for i in board:
        temp.append(deque(i))

    while moves:
        a = moves.popleft()-1
        if any(temp[a]) == False:
            continue
        while True:
            b = temp[a].popleft()
            if b != 0:
                break
        lst.append(b)

        if len(lst)>=2 and lst[-1] == lst[-2]:
            cnt += 2
            lst.pop(); lst.pop()
            
    return cnt
