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


# 자료구조 중 덱을 이용. 스택이지만 이게 편해서 했다.
# board를 층별로 아닌 열별로 재정렬을 한다. moves가 열로 넘버링이 되어있기 때문이다.
# 스택에서 두개가 연속이 되면 pop 할 것.
