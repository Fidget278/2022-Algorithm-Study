# https://leetcode.com/problems/ransom-note/submissions/

from collections import Counter
class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        c1 = Counter(ransomNote)
        c2 = Counter(magazine)
        if len(c1-c2) == 0:
            return True
        return False
