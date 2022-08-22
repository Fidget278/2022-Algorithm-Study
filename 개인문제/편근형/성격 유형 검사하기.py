# https://school.programmers.co.kr/learn/courses/30/lessons/118666

from collections import defaultdict
def solution(survey, choices):
    answer = ''
    d = defaultdict(int)
    
    for i, j in zip(survey, choices):
        if j > 4: 
            d[i[1]] += j-4
        elif j < 4:
            d[i[0]] += 4-j
            
    answer += 'R' if d['R'] >= d['T'] else 'T'
    answer += 'C' if d['C'] >= d['F'] else 'F'
    answer += 'J' if d['J'] >= d['M'] else 'M'
    answer += 'A' if d['A'] >= d['N'] else 'N'
    return answer
