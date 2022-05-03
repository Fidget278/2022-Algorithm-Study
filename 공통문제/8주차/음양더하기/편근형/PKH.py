def solution(absolutes, signs):
    answer = 0
    for i,j in zip(absolutes, signs):
        if j == False:
            answer -= i
        else:
            answer += i
    return answer


# sign에 따라서 '+', '-'를 정해 반환값에 더하거나 빼는 방식 
