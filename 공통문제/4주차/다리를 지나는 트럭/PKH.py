def solution(bridge_length, weight, truck_weights):
    answer = 0
    move = [0 for i in truck_weights]
    temp1 = []; temp2 = []
    
    while True:
        if truck_weights:
            a = truck_weights.pop(0)
            temp1.append(a); temp2.append(0)
            
        if sum(temp1) > weight:
            del temp1[-1]; del temp2[-1]
            truck_weights.insert(0,a)
            
        temp2 = [i+1 for i in temp2]
        if temp2[0] >= bridge_length:
            del temp1[0]; del temp2[0]
        answer += 1
        
        if not temp1 and not truck_weights:
            answer += 1
            break
    return answer
