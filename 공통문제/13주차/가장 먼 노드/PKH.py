from collections import deque

def make_set(nodes):
    for node in nodes:
        node.sort()
    nodes.sort()
    routes = dict()
    for a,b in nodes:
        routes.setdefault(a,[]).append(b)
        routes.setdefault(b,[]).append(a)
    return routes

def solution(n,edge):
    routes = make_set(edge)
    deq = deque([[1,0]])
    check = [-1] * n
    
    while deq:
        node, distance = deq.popleft()
        if check[node-1] == -1:
            check[node-1] = 0
        for i in routes[node]:
            if check[i-1] == -1:
                check[i-1] = 0
                deq.append([i, distance+1])
        check[node-1] = distance
        distance += 1
    ret = check.count(max(check))
    return ret
