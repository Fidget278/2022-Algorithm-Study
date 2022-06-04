def solution(brown, yellow):
    sum = brown + yellow
    temp = [i for i in range(1,sum+1) if sum % i == 0]
    std = len(temp) // 2
    col = temp[std:]
    col.sort(reverse = True)
    if len(temp) % 2 == 0:
        row = temp[:std]
    else:
        row = temp[:std+1]
    for i,j in zip(row,col):
        if 2*(i+j-2) == brown:
            answer = [j,i]
            break
    return answer

'''
1. 사각 배열로 둘 것이기 때문에 총 카펫의 갯수를 구하고 그 수의 약수를 구한다.
2. 가로 길이가 세로 길이보다 길거나 같기 때문에 약수들을 반으로 나눠 큰 수들의 리스트를 가로, 작은 수들의 리스트를 세로로 둔다.
3. 12 같은 경우, (1,12),(2,6).. 이렇듯이 작은 수들이 오름차순이 된다면 큰 수들은 내림차순으로 되기 때문에 7번째 줄을 보면 내림차순으로 정렬하였다.
4. 제곱수들은 약수가 홀수 개이다. 그 이유는 약수 중 제곱근 수가 존재하기 때문이다. 그래서 가로, 세로에 모두 포함시켜야 한다. (7~10 줄)
5. 테두리만 갈색이어야 하므로 가로와 세로 경우의 수를 돌리면서 테두리만 구하는 식에 적용. (11~14)
'''
