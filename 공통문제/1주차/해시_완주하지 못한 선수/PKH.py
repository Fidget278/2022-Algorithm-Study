import collections as c

def solution(participant, completion):
    answer = c.Counter(participant) - c.Counter(completion)
    return list(answer.keys())[0]

'''
Counter 클래스는 dict형으로 변환시켜준다. 해당 클래스는 원소를 key, 해당 원소의 개수를 value로 잡아주는 클래스이다.
dict형에서 원소에 접근할 때 발생하는 시간복잡도는 O(1)이므로 Counter의 시간 복잡도는 O(n)이다.
어차피 완주 못한 자는 1명이므로 Counter를 사용해 남은 원소의 key만을 보여주면 된다.
'''
