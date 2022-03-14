from itertools import permutations
def solution(numbers):
    num = list(numbers)
    for i in range(2,len(numbers)+1):
        n = list(permutations(numbers,i))
        for j in n:
            if len(j) <= len(numbers):
                num.append(''.join(j))
    num = list(set([int(x) for x in num]))
    
    # 0과 1은 제외
    if num.count(1):
        num.remove(1)
    if num.count(0):
        num.remove(0)
    
    num.sort()
    answer = len(num)
    for i in num:
        x = 2
        while x**2 <= i:
            # 소수가 아니면 뺀다.
            if i % x == 0:
                answer -= 1
                break
            x += 1
    return answer

# permutations는 순열을 구하는 모듈이다.
