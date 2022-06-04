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

'''
이 문제는 Union-find 알고리즘을 이용해서 풀었다.

1. 일단 모든 노드가 연결되어 있어야 한다. 그러기 위해서는 최소한 (노드의 개수 - 1) 개의 선이 존재해야 한다. 그러므로 먼저 connection의 개수를 구하고 적으면 -1을 return 한다.
2. union-find를 정의한다. 이 알고리즘은 상호 배타적인 집합을 표현하는 것이다. 연결되어 있지 않는 조합을 찾는데 유용하다.
3. find를 통해서 해당 노드의 루트 노드를 찾는 것이고, union은 둘 중 어느 노드가 부모 노드인지를 보는 것이다. 부모 노드는 노드값의 최솟값으로 가려는 경향이 있다. 이것을 합쳐서 각 노드의 루트 노드를 찾는 것이다.
4. 문제에서는 모든 노드가 연결되어 있어야 하므로 모든 노드의 루트 노드는 0이 된다.
5. union-find를 통해서 0이 아닌 집합이 있다면 그 노드는 루트로 연결이 되어 있지 않는다는 뜻이다. 
6. 루트로 연결되어 있지 않는 노드들의 숫자를 보고 숫자의 종류 수를 카운트를 하면 답이 된다. 종류 수를 카운트를 하는 이유는 루트 노드가 아닌 노드끼리도 연결이 될 경우가 있기 때문에 그 경우에는 굳이 재설정할 필요가 없기 때문이다.
7. 카운트할 때 0인 경우도 있으므로 -1을 해주는 것이다.
'''
