# 링크 : https://leetcode.com/problems/fibonacci-number/
# 시간 : 34ms faster than 88.28%
# 재귀보다는 메모이제이션이 빠르다.

class Solution:
    def fib(self, n: int) -> int:
        if n == 0: return 0
        elif n == 1: return 1
        lst = [0] * (n+1)
        lst[1] = 1
        for i in range(2, n+1):
            lst[i] = lst[i-1] + lst[i-2]
        return lst[n]
