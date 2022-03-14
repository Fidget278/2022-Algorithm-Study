def solution(bridge_length, weight, truck_weights):
    answer = 0
    temp1 = []; temp2 = []
    
    while True:
        # 대기 중인 트럭이 있을 경우
        if truck_weights:
            a = truck_weights.pop(0)
            temp1.append(a); temp2.append(0)
        
        # 운행 중인 트럭의 무게가 디리의 부하 무게보다 클 경우
        if sum(temp1) > weight:
            del temp1[-1]; del temp2[-1]
            truck_weights.insert(0,a)
        
        temp2 = [i+1 for i in temp2]
        if temp2[0] >= bridge_length:
            del temp1[0]; del temp2[0] # 맨 앞 차량이 다리를 다 건넌 것이기 떄문에 삭제
        answer += 1 # 시간은 계속 흘러가므로 +1
        
        # 아무것도 없을 때까지는 해야하니 시간에 +1
        if not temp1 and not truck_weights:
            answer += 1
            break
    return answer
