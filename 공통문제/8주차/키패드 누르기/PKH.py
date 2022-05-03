def solution(numbers, hand):
    answer = ''
    pad = [[1,4,7,'*'],[2,5,8,0],[3,6,9,'#']]
    left, right = [0,3], [2,3]
    for i in numbers:
        if i in pad[0]:
            answer += 'L'
            j = pad[0].index(i)
            left = [0, j]
        elif i in pad[2]:
            answer += 'R'
            j = pad[2].index(i)
            right = [2, j]
        else:
            j = pad[1].index(i)
            lr = abs(1 - left[0]) + abs(j - left[1])
            rr = abs(1 - right[0]) + abs(j - right[1])
            if (lr > rr) or (lr == rr and hand == "right"):
                answer += 'R'
                right = [1, j]
            elif (rr > lr) or (lr == rr and hand == "left"):
                answer += 'L'
                left = [1,j]
    return answer

# 패드를 열별로 구현.
# 경우의 수에 따라서 문자열을 더하는 방식으로 한다.
# index 메소드는 해당 값의 배열의 인덱스를 추출하는 메소드이다.
