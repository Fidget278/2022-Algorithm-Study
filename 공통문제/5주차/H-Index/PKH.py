def solution(citations):
    answer = 0
    citations.sort(reverse = True)
    answer = max(map(min, enumerate(citations, start = 1)))
    return answer
