# 시간 : 44ms
# 메모리 : 13.5MB
# 시간 복잡도 : O(n)
# 링크 : https://leetcode.com/problems/longest-substring-without-repeating-characters

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        left = 0
        ans = 0
        used = {}
        
        for right, c in enumerate(s):
            if c in used and left <= used[c]:
                left = used[c] + 1
            else:
                ans = max(ans, right - left + 1)
            used[c] = right
        return ans
