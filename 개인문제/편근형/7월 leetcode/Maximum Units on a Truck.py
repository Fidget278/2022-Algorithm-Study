# 링크 : https://leetcode.com/problems/maximum-units-on-a-truck/
# 시간 : 163 ms faster than 92.58%
# 시간을 빠르게 하기위해 deque을 사용

from collections import deque
class Solution:
    def maximumUnits(self, boxTypes: List[List[int]], truckSize: int) -> int:
        re_list = deque(sorted(boxTypes, key=lambda x:x[1]))
        answer = 0
        while True:
            if (truckSize == 0 or len(re_list) == 0):
                break
            boxCnt, unitCnt = re_list.pop()
            answer += (boxCnt * unitCnt) if truckSize >= boxCnt else (unitCnt * truckSize)
            truckSize -= boxCnt if truckSize >= boxCnt else truckSize
        return answer
