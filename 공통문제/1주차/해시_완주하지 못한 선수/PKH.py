# Counter 클래스의 시간복잡도는 O(n)이다.
import collections as c

def solution(participant, completion):
    answer = c.Counter(participant) - c.Counter(completion)
    return list(answer.keys())[0]
