# 링크 : https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/

from collections import defaultdict

class Solution:
    def minDeletions(self, s: str) -> int:
        d = defaultdict(int)
        for c in s:
            d[c] += 1
        lst = list(sorted(list(d.values()), reverse = True))
        if(len(lst) == 1):
            return 0
        temp = [lst[0]]
        for i in range(1, len(lst)):
            num = lst[i]
            while True:
                if num not in temp:
                    temp.append(num)
                    break
                if num == 0:
                    break
                num -= 1
        
        return (len(s) - sum(temp))
