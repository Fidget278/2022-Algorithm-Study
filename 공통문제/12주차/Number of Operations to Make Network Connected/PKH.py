class Solution:
    def makeConnected(self, n: int, connections: List[List[int]]) -> int:
        parent = [x for x in range(n)]
        l = len(connections)
        if n-1 > l:
            return -1
        
        def find(x):
            if parent[x] != x:
                return find(parent[x])
            return x
        
        def union(a,b):
            a = find(a)
            b = find(b)
            
            if a < b:
                parent[b] = a
            else:
                parent[a] = b
        
        for i,j in connections:
            union(i,j)
        
        cnt = 0
        for a in range(n):
            if a == find(a):
                cnt += 1
        return cnt -1
