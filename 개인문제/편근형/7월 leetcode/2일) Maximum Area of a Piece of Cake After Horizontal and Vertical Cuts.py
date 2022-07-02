# 링크 : https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
# 시간 : 395ms faster than 69.96%

class Solution:
    def maxArea(self, h: int, w: int, horizontalCuts: List[int], verticalCuts: List[int]) -> int:
        answer = 0
        horizontalCuts = [0] + horizontalCuts + [h]
        verticalCuts = [0] + verticalCuts + [w]
        verticalCuts.sort(); horizontalCuts.sort()
        V = max([verticalCuts[i] - verticalCuts[i-1] for i in range(len(verticalCuts)-1, 0, -1)])
        H = max([horizontalCuts[i] - horizontalCuts[i-1] for i in range(len(horizontalCuts)-1, 0, -1)])
        answer = V * H
        return answer % (int(1e9+7))
