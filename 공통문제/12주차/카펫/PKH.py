from operator import mul
def solution(brown, yellow):
    sum = brown + yellow
    temp = [i for i in range(1,sum+1) if sum % i == 0]
    std = len(temp) // 2
    row = temp[std:]
    row.sort(reverse = True)
    if len(temp) % 2 == 0:
        col = temp[:std]
    else:
        col = temp[:std+1]
    answer = [j,i for i,j in zip(col,row) if (mul(2,i)+mul(2,j)-4) == brown]
    return answer
