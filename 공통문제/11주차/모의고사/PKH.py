def solution(answers):
    answer = []
    cnt = [0]*3
    prob = len(answers)
    st = [1,2,3,4,5]*2000; nd = [2,1,2,3,2,4,2,5]*1250; rd = [3,3,1,1,2,2,4,4,5,5]*1000
    fix_st = st[:prob]; fix_nd = nd[:prob]; fix_rd = rd[:prob]
    
    for i,j,k,l in zip(answers, fix_st, fix_nd, fix_rd):
        if j == i:
            cnt[0] += 1
        if k == i:
            cnt[1] += 1
        if l == i:
            cnt[2] += 1
    ret = max(cnt)
    for i in range(len(cnt)):
        if cnt[i] == ret:
            answer.append(i+1)
    return answer
