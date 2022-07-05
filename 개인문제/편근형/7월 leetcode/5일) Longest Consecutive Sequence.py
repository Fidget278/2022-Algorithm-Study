# 링크 : https://leetcode.com/problems/longest-consecutive-sequence/
# 시간 : 322 ms faster than 94.53%

class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        nums = list(set(nums))
        nums.sort()
        cnt, ret = 1, 1
        for i in range(1, len(nums)):
            if nums[i] - nums[i-1] == 1:
                cnt += 1
            else:
                ret = max(ret, cnt)
                cnt = 1
        ret = max(ret, cnt)
        return ret
