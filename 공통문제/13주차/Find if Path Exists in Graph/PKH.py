from collections import defaultdict, deque

class Solution:
    def validPath(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        d = defaultdict(deque)
        
        for i,j in edges:
            d[i].append(j)
            d[j].append(i)
            
        q = deque([source])
        visited = [source]
        while q:
            now = q.popleft()
            if now == destination:
                return True
            for Next in d[now]:
                if Next not in visited:
                    visited.append(Next)
                    q.append(Next)  
        return False
