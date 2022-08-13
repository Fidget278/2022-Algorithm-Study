def solution(word):
    answer = 0
    d = {'A':1, 'E':2, 'I':3, 'O':4, 'U':5}
    diff = [781,156,31,6,1]
    for i,j in zip(word, range(len(word))):
        print(j)
        answer += ((d[i]-1) * diff[j]) + 1
    return answer
