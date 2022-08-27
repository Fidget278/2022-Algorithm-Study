# https://leetcode.com/problems/reordered-power-of-2/
# 55ms, 13.8MB

class Solution:
    def reorderedPowerOf2(self, n: int) -> bool:
        lst = [str(2 ** i) for i in range(30)]
        n = str(n)
        for i in lst:
            if sorted(n) == sorted(i):
                return True
        return False
