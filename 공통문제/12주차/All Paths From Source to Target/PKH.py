from collections import defaultdict,deque
from copy import deepcopy
class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        answer = []
        d = defaultdict(deque)
        for i in range(len(graph)):
            for j in graph[i]:
                d[i].append(j)
        if len(d[0]) == 0:
            return []
        
        n = len(graph)
        def check(lst, target):
            if target == n-1:
                ret = deepcopy(lst)
                answer.append(ret)
                lst.pop()
                return
            for a in d[target]:
                lst.append(a)
                check(lst,a)
            lst.pop()
        
        q = [0]
        check(q, 0)
        return answer

'''
DFS 문제로 저번에 풀었던 Path Sum II와 동일하게 풀었다.
'''
