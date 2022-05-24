from collections import deque
import re

class Solution:
    def lengthLongestPath(self, input: str) -> int:
        lst = deque(input.split('\n'))
        file_matching = re.compile('.*\..*')
        if len(lst) == 1:
            if file_matching.match(lst[0]):
                return len(lst[0])
            return 0
        
        stack = [lst.popleft()]
        level, answer = 0, 0
        
        while lst:
            sub = lst.popleft()
            cnt = sub.count('\t')
            sub_mod = sub.replace('\t','')
            if level >= cnt:
                while level >= cnt:
                    stack.pop()
                    level -= 1
            stack.append(sub_mod)
            level = cnt
            if file_matching.match(sub_mod):
                ret = len('/'.join(stack))
                answer = max(answer, ret)
        return answer
