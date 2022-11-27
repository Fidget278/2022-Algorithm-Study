# 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/72413

import heapq
def solution(n, s, a, b, fares):
    answer = int(1e9)
    graph = [[] for _ in range(n+1)]
    distance = [int(1e9)] * (n+1)
    for fare in fares:
        p1, p2, fee = fare[0], fare[1], fare[2]
        graph[p1].append((p2, fee))
        graph[p2].append((p1, fee))
    
    def dijkstra(start):
        q = []
        heapq.heappush(q, (0, start))
        distance[start] = 0
        
        while q:
            dist, now = heapq.heappop(q)
            if distance[now] < dist:
                continue
            
            for i in graph[now]:
                cost = i[1] + dist
                if cost < distance[i[0]]:
                    distance[i[0]] = cost
                    heapq.heappush(q, (cost, i[0]))
        return distance
    t1 = dijkstra(s)
    for i in range(1, n+1):
        distance = [int(1e9)] * (n+1)
        t2 = dijkstra(i)
        answer = min(answer, t2[a] + t2[b] + t1[i])
    return answer
