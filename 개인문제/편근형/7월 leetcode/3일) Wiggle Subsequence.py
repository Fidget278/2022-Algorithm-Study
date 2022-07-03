# 링크 : https://leetcode.com/problems/wiggle-subsequence/
# 시간 : 37ms faster than 91.17%

class Solution:
    def wiggleMaxLength(self, nums: List[int]) -> int:
        point, length = 1, len(nums)
        cnt = 0
        post = 0
        up, down = True, True
        while point < length:
            now = nums[point] - nums[point-1]
            if (now > 0) == up and post <= 0:
                post = now
                flag = False
                cnt += 1
            elif (now < 0) == down and post >= 0:
                post = now
                flag = True
                cnt += 1
            point += 1
        return cnt + 1
