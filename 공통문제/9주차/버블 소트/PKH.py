# 시간 : 1064ms

import sys
ssr = sys.stdin.readline

n = int(ssr())
lst = [(int(ssr()), i) for _, i in enumerate(range(n))]
sort_lst = sorted(lst)
answer = max([sort_lst[i][1] - lst[i][1] for i in range(n)])
print(answer+1)
