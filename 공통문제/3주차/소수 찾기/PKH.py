from itertools import permutations
def solution(numbers):
    answer = 0
    num = list(numbers)
    for i in range(2,len(numbers)+1):
        n = list(permutations(numbers,i))
        for j in n:
            if len(j) <= len(numbers):
                num.append(''.join(j))
    num = list(set([int(x) for x in num]))
    
    if num.count(1):
        num.remove(1)
    if num.count(0):
        num.remove(0)
    num.sort()
    print(num)
    for i in num:
        x = 2
        while x**2 <= i:
            if i % x == 0:
                answer -= 1
                break
            x += 1
        answer += 1
    return answer
