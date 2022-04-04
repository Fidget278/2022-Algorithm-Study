def solution(n, lost, reserve):
    set_reserve = set(reserve) - set(lost) # 여별옷을 가지고 있는 사람 중 원래 체육복을 잃어버린 사람을 제거.
    set_lost = set(lost) - set(reserve) # 잃어버린 사람 중 여벌옷을 가지고 있는 사람을 제거
    
    for i in set_reserve:
        if i-1 in set_lost:
            set_lost.remove(i-1)
        elif i+1 in set_lost:
            set_lost.remove(i+1)
    return n-len(set_lost)
