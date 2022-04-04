from itertools import product
def solution(numbers, target):
    # product : 데카르트 곱
    l = [(i,-i) for i in numbers]
    ret = (list(map(sum,product(*l))))
    answer = ret.count(target)
    return answer
