# 링크 : https://leetcode.com/problems/coin-change/
# 시간 : 1556ms

from collections import deque

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        lst = [-1] * (amount + 1)
        lst[0] = 0
        
        for idx in range(amount + 1):
            for coin in coins:
                rem = idx - coin
                if rem < 0 or lst[rem] == -1:
                    continue
                ret = lst[rem] + 1
                if lst[idx] == -1:
                    lst[idx] = ret
                else:
                    lst[idx] = min(lst[idx], ret)
        return lst[amount]
